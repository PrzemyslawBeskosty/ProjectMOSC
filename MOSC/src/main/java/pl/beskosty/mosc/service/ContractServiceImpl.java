package pl.beskosty.mosc.service;

import java.util.List;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.beskosty.mosc.dao.ContractDAO;
import pl.beskosty.mosc.entity.Contract;

/**
 *
 * @author Przemek
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDAO contractDAO;

    @Override
    public void createContract(Contract contract) {
        contract.setStatus("A");
        contract.setContractNumber(contract.getContractNumber().replace(" ", ""));
        contractDAO.createContract(contract);
    }

    @Override
    public List<Contract> getContracts() {
        return contractDAO.getContracts();
    }

    @Override
    public Contract getContract(int id) {
        return contractDAO.getContract(id);
    }

    @Override
    public void updateContract(Contract contract) {
        contract.setContractNumber(contract.getContractNumber().replace(" ", ""));
        contractDAO.updateContract(contract);
    }

    @Override
    public void deactivateContract(int id) {
        contractDAO.deactivateContract(id);
    }

    @Override
    public void uploadContracts(List<Contract> contracts) {
        if (contracts == null || contracts.isEmpty()) {
            return;
        }
        contractDAO.uploadContracts(contracts);
    }

}
