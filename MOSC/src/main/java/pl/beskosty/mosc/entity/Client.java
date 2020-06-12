package pl.beskosty.mosc.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pl.beskosty.mosc.enums.Status;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "softwareClient",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<Software> systems;

    public Client() {
    }

    /**
     * Checking if the object is active.
     *
     * @return True if is active.
     */
    public boolean isActive() {
        return Status.ACTIVE.equals(Status.getStatusFromCode(status));
    }

    /**
     * Function return full name of status
     *
     * @return Full name from Status.
     */
    public String getStatusBundled() {
        return Status.getStatusFromCode(status).getValue();
    }

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void add(Software tempSystem) {
        if (systems == null) {
            systems = new ArrayList<>();
        }
        systems.add(tempSystem);
    }

}
