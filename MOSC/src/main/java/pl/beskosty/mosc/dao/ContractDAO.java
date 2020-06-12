package pl.beskosty.mosc.dao;

import java.util.List;
import pl.beskosty.mosc.entity.Contract;

/**
 *
 * @author Przemek
 */
public interface ContractDAO {

    public void createContract(Contract contract);

    public List<Contract> getContracts();

    public Contract getContract(int id);

    public void updateContract(Contract Contract);

    public void deactivateContract(int id);

    public void uploadContracts(List<Contract> contracts);
}
