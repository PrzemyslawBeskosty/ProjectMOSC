package pl.beskosty.mosc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.beskosty.mosc.entity.Software;

/**
 *
 * @author Przemek
 */
@Repository
public class SoftwareDAOImpl implements SoftwareDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createSoftware(Software software) {
        createOrUpdateSoftware(software);
    }

    @Override
    public List<Software> getSoftwares() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Software> query = currentSession.createQuery("FROM Software", Software.class);
        List<Software> softwares = query.getResultList();

        return softwares;
    }

    @Override
    public Software getSoftware(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Software software = currentSession.get(Software.class, id);

        return software;
    }

    @Override
    public void updateSoftware(Software software) {
        createOrUpdateSoftware(software);
    }

    @Override
    public void deactivateSoftware(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("UPDATE Software SET status = 'N' WHERE id=:softwareId");
        query.setParameter("softwareId", id);
        query.executeUpdate();
    }

    private void createOrUpdateSoftware(Software software) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(software);
    }

}
