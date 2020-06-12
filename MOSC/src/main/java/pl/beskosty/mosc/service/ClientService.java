package pl.beskosty.mosc.service;

import java.util.List;
import pl.beskosty.mosc.entity.Client;

/**
 *
 * @author Przemek
 */
public interface ClientService {

    public void createClient(Client client);

    public List<Client> getClients();

    public Client getClient(int id);

    public void updateClient(Client client);

    public void deactivateClient(int id);

}
