package pl.beskosty.mosc.dao;

import java.util.List;
import pl.beskosty.mosc.entity.Client;

/**
 *
 * @author Przemek
 */
public interface ClientDAO {

    public void createClient(Client client);

    public List<Client> getClients();

    public Client getClient(int id);

    public void updateClient(Client client);

    public void deactivateClient(int id);

}
