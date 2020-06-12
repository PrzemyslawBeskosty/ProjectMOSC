package pl.beskosty.mosc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.beskosty.mosc.dao.SoftwareDAO;
import pl.beskosty.mosc.entity.Software;

/**
 *
 * @author Przemek
 */
@Service
@Transactional
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareDAO softwareDAO;

    @Override
    public void createSoftware(Software software) {
        software.setStatus("A");
        softwareDAO.createSoftware(software);
    }

    @Override
    public List<Software> getSoftwares() {
        return softwareDAO.getSoftwares();
    }

    @Override
    public Software getSoftware(int id) {
        return softwareDAO.getSoftware(id);
    }

    @Override
    public void updateSoftware(Software software) {
        softwareDAO.updateSoftware(software);
    }

    @Override
    public void deactivateSoftware(int id) {
        softwareDAO.deactivateSoftware(id);
    }

}
