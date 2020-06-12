package pl.beskosty.mosc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.beskosty.mosc.dao.ClientDAO;
import pl.beskosty.mosc.entity.Client;

/**
 *
 * @author Przemek
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createClient(Client client) {
        createOrUpdateClient(client);
    }

    @Override
    public List<Client> getClients() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Client> query = currentSession.createQuery("FROM Client", Client.class);
        List<Client> clients = query.getResultList();

        return clients;
    }

    @Override
    public Client getClient(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Client client = currentSession.get(Client.class, id);

        return client;
    }

    @Override
    public void updateClient(Client client) {
        createOrUpdateClient(client);
    }

    @Override
    public void deactivateClient(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("UPDATE Client SET status = 'N' WHERE id=:clientId");
        query.setParameter("clientId", id);
        query.executeUpdate();
    }

    private void createOrUpdateClient(Client client) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(client);
    }

}
