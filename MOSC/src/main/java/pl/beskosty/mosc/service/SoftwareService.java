package pl.beskosty.mosc.service;

import java.util.List;
import pl.beskosty.mosc.entity.Software;

/**
 *
 * @author Przemek
 */
public interface SoftwareService {

    public void createSoftware(Software client);

    public List<Software> getSoftwares();

    public Software getSoftware(int id);

    public void updateSoftware(Software client);

    public void deactivateSoftware(int id);

}
