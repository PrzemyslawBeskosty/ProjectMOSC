package pl.beskosty.mosc.dao;

import java.util.List;
import pl.beskosty.mosc.entity.Software;

/**
 *
 * @author Przemek
 */
public interface SoftwareDAO {

    public void createSoftware(Software software);

    public List<Software> getSoftwares();

    public Software getSoftware(int id);

    public void updateSoftware(Software software);

    public void deactivateSoftware(int id);

}
