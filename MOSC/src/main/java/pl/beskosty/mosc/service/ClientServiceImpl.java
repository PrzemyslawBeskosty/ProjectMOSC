package pl.beskosty.mosc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.beskosty.mosc.dao.ClientDAO;
import pl.beskosty.mosc.entity.Client;

/**
 *
 * @author Przemek
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public void createClient(Client client) {
        client.setStatus("A");
        clientDAO.createClient(client);
    }

    @Override
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @Override
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    @Override
    public void deactivateClient(int id) {
        clientDAO.deactivateClient(id);
    }

}
