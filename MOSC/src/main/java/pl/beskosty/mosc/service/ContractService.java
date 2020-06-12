package pl.beskosty.mosc.service;

import java.util.List;
import pl.beskosty.mosc.entity.Contract;

/**
 *
 * @author Przemek
 */
public interface ContractService {

    public void createContract(Contract client);

    public List<Contract> getContracts();

    public Contract getContract(int id);

    public void updateContract(Contract client);

    public void deactivateContract(int id);

    public void uploadContracts(List<Contract> contracts);

}
