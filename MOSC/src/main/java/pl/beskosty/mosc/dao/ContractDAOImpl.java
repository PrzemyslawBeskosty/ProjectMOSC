package pl.beskosty.mosc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.beskosty.mosc.entity.Contract;

/**
 *
 * @author Przemek
 */
@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createContract(Contract contract) {
        createOrUpdateContract(contract);
    }

    @Override
    public List<Contract> getContracts() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Contract> query = currentSession.createQuery("FROM Contract", Contract.class);
        List<Contract> contracts = query.getResultList();

        return contracts;
    }

    @Override
    public Contract getContract(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Contract contract = currentSession.get(Contract.class, id);

        return contract;
    }

    @Override
    public void updateContract(Contract contract) {
        createOrUpdateContract(contract);
    }

    @Override
    public void deactivateContract(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("UPDATE Contract SET status = 'N' WHERE id=:contractId");
        query.setParameter("contractId", id);
        query.executeUpdate();
    }

    private void createOrUpdateContract(Contract contract) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(contract);
    }

    @Override
    public void uploadContracts(List<Contract> contracts) {
        Session currentSession;
        currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        for (int i = 0; i < contracts.size(); i++) {
            currentSession.save(contracts.get(i));
        }
        transaction.commit();
        currentSession.close();
    }

}
