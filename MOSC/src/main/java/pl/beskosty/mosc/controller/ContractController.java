package pl.beskosty.mosc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.beskosty.mosc.apachepoi.ApachePoiImporter;
import pl.beskosty.mosc.entity.Contract;
import pl.beskosty.mosc.entity.Software;
import pl.beskosty.mosc.enums.AmountType;
import pl.beskosty.mosc.enums.Currency;
import pl.beskosty.mosc.enums.AmountPeriod;
import pl.beskosty.mosc.service.ContractService;
import pl.beskosty.mosc.service.SoftwareService;

/**
 *
 * @author Przemek
 */
@Controller
public class ContractController {

    @Autowired
    private SoftwareService softwareService;

    @Autowired
    private ContractService contractService;

    @GetMapping("showCreateContractForm")
    public String createContractForm(Model model) {
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        addAtributesToModel(model);

        return "/contracts/create-contract";
    }

    @PostMapping("createContractAction")
    public String createContract(HttpServletRequest request) {
        Contract contract = createContractFromRequest(request);
        try {
            contractService.createContract(contract);
        } catch (Exception e) {

        }
        return "redirect:/showContractsForm";
    }

    @PostMapping("uploadContractAction")
    public String uploadContract(@RequestParam("file") MultipartFile cmFile, HttpServletRequest request) {
        ApachePoiImporter poi;
        try {
            poi = new ApachePoiImporter(cmFile.getInputStream(), cmFile.getOriginalFilename(), softwareService.getSoftwares());
            contractService.uploadContracts(poi.getContracts());
        } catch (Exception e) {

        }
        return "redirect:/showContractsForm";
    }

    @GetMapping("showContractsForm")
    public String contractsForm(Model model
    ) {
        List<Contract> allContracts = contractService.getContracts();
        List<Contract> activeContracts = getActiveContracts(allContracts);

        model.addAttribute("allContracts", allContracts);
        model.addAttribute("activeContracts", activeContracts);

        return "/contracts/contracts";
    }

    @GetMapping("showUpdateContractForm")
    public String updateContractForm(@RequestParam("contractId") int id, Model model
    ) {
        Contract contract = contractService.getContract(id);
        model.addAttribute("contract", contract);
        addAtributesToModel(model);

        return "/contracts/create-contract";
    }

    @GetMapping("deleteContractAction")
    public String deleteContract(@RequestParam("contractId") int id, Model model
    ) {
        contractService.deactivateContract(id);

        return "redirect:/showContractsForm";
    }

    private Contract createContractFromRequest(HttpServletRequest request) {
        //Prepare
        String id = request.getParameter("id");
        String contractNumber = request.getParameter("contractNumber");
        String clientSystem = request.getParameter("clientSystem");
        if (clientSystem == null) {
            return null;
        }
        LocalDate dateFrom = null;
        LocalDate dateTo = null;
        if (!request.getParameter("dateFrom").isEmpty()) {
            dateFrom = LocalDate.parse(request.getParameter("dateFrom"));
            if (!request.getParameter("dateTo").isEmpty()) {
                dateTo = LocalDate.parse(request.getParameter("dateTo"));
                if (dateFrom.isAfter(dateTo)) {
                    return null;
                }
            }
        }
        Integer amount = Integer.valueOf(request.getParameter("amount"));
        if (amount <= 0) {
            return null;
        }
        String currency = request.getParameter("currency");
        String amountType = request.getParameter("amountType");
        String amountPeriod = request.getParameter("amountPeriod");
        //Insert data
        Contract contract = new Contract();
        if (!id.isEmpty()) {
            contract.setId(Integer.valueOf(id));
        }
        contract.setContractNumber(contractNumber);

        contract.setClientSystem(softwareService.getSoftware(Integer.valueOf(clientSystem)));
        contract.setDateFrom(dateFrom);
        contract.setDateTo(dateTo);
        contract.setAmount(amount);
        contract.setCurrency(currency);
        contract.setAmountType(amountType);
        contract.setAmountPeriod(amountPeriod);
        //Return
        return contract;
    }

    private void addAtributesToModel(Model model) {
        //Add list of softwares
        model.addAttribute("listOfSoftwares", getActiveSoftwares(softwareService.getSoftwares()));
        //Add enum maps
        model.addAttribute("currencyMap", Currency.getCurrencyMap());
        model.addAttribute("amountTypeMap", AmountType.getAmountTypeMap());
        model.addAttribute("amountPeriodMap", AmountPeriod.getAmountPeriodMap());

    }

    /**
     * Based on the parameter, the function prepares a list of contracts with an
     * active status.
     *
     * @param allContracts
     * @return List with only active contracts. Return new ArrayList if list is
     * empty or null.
     */
    private List<Contract> getActiveContracts(List<Contract> allContracts) {
        if (allContracts == null || allContracts.isEmpty()) {
            return new ArrayList<>();
        }
        return allContracts
                .stream()
                .filter(c -> c.isActive())
                .collect(Collectors.toList());
    }

    /**
     * Based on the parameter, the function prepares a list of softwares with an
     * active status.
     *
     * @param softwares
     * @return List with only active softwares. Return new ArrayList if list is
     * empty or null.
     */
    private List<Software> getActiveSoftwares(List<Software> softwares) {
        if (softwares == null || softwares.isEmpty()) {
            return new ArrayList<>();
        }

        return softwares.
                stream()
                .filter(c -> c.isActive())
                .collect(Collectors.toList());
    }

}
