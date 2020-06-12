package pl.beskosty.mosc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pl.beskosty.mosc.enums.Status;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "systems")
public class Software implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tech_desc")
    private String technicalDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client softwareClient;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "clientSystem",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<Contract> contracts;

    public Software() {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public Client getSoftwareClient() {
        return softwareClient;
    }

    public void setSoftwareClient(Client softwareClient) {
        this.softwareClient = softwareClient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void add(Contract tempContract) {
        if (contracts == null) {
            contracts = new ArrayList<>();
        }

        tempContract.setClientSystem(this);
        contracts.add(tempContract);
    }

}
