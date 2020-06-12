package pl.beskosty.mosc.controller;

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
import pl.beskosty.mosc.entity.Client;
import pl.beskosty.mosc.entity.Software;
import pl.beskosty.mosc.service.ClientService;
import pl.beskosty.mosc.service.SoftwareService;

/**
 *
 * @author Przemek
 */
@Controller
public class SoftwareController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SoftwareService softwareService;

    @GetMapping("showCreateSoftwareForm")
    public String createSoftwareForm(Model model) {
        Software software = new Software();
        model.addAttribute("software", software);
        model.addAttribute("listOfClients", getActiveClients(clientService.getClients()));

        return "/softwares/create-software";
    }

    @PostMapping("createSoftwareAction")
    public String createSoftware(HttpServletRequest request) {
        Software software = createSoftwareFromRequest(request);
        try {
            softwareService.createSoftware(software);
        } catch (Exception e) {

        }
        return "redirect:/showSoftwaresForm";
    }

    private Software createSoftwareFromRequest(HttpServletRequest request) {
        //Prepare
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String technicalDescription = request.getParameter("technicalDescription");
        String softwareClient = request.getParameter("softwareClient");
        if (softwareClient == null) {
            return null;
        }

        //InsertData
        Software software = new Software();
        if (!id.isEmpty()) {
            software.setId(Integer.valueOf(id));
        }
        software.setName(name);
        software.setDescription(description);
        software.setTechnicalDescription(technicalDescription);
        software.setSoftwareClient(clientService.getClient(Integer.valueOf(softwareClient)));

        //Return
        return software;
    }

    @GetMapping("showSoftwaresForm")
    public String softwaresForm(Model model) {
        List<Software> allSoftwares = softwareService.getSoftwares();
        List<Software> activeSoftwares = getActiveSoftwares(allSoftwares);

        model.addAttribute("allSoftwares", allSoftwares);
        model.addAttribute("activeSoftwares", activeSoftwares);

        return "/softwares/softwares";
    }

    @GetMapping("showUpdateSoftwareForm")
    public String updateSoftwareForm(@RequestParam("softwareId") int id, Model model) {
        Software software = softwareService.getSoftware(id);

        model.addAttribute("software", software);
        model.addAttribute("listOfClients", getActiveClients(clientService.getClients()));

        return "/softwares/create-software";
    }

    @GetMapping("deleteSoftwareAction")
    public String deleteSoftware(@RequestParam("softwareId") int id, Model model) {
        softwareService.deactivateSoftware(id);

        return "redirect:/showSoftwaresForm";
    }

    /**
     * Based on the parameter, the function prepares a list of Softwares with an
     * active status.
     *
     * @param allSoftwares
     * @return List with only active Softwares. Return new ArrayList if list is
     * empty or null.
     */
    private List<Software> getActiveSoftwares(List<Software> allSoftwares) {
        if (allSoftwares == null || allSoftwares.isEmpty()) {
            return new ArrayList<>();
        }
        return allSoftwares
                .stream()
                .filter(c -> c.isActive())
                .collect(Collectors.toList());
    }

    /**
     * Based on the parameter, the function prepares a list of Clients with an
     * active status.
     *
     * @param clients
     * @return List with only active Clients. Return new ArrayList if list is
     * empty or null.
     */
    private List<Client> getActiveClients(List<Client> clients) {
        if (clients == null || clients.isEmpty()) {
            return new ArrayList<>();
        }
        return clients.
                stream()
                .filter(c -> c.isActive())
                .collect(Collectors.toList());
    }
}
