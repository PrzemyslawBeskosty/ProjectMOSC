package pl.beskosty.mosc.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import pl.beskosty.mosc.enums.AmountType;
import pl.beskosty.mosc.enums.Currency;
import pl.beskosty.mosc.enums.AmountPeriod;
import pl.beskosty.mosc.enums.Status;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "contract_number")
    private String contractNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "system_id")
    private Software clientSystem;

    @Column(name = "date_from")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency = "PLN";

    @Column(name = "amount_type")
    private String amountType;

    @Column(name = "amount_period")
    private String amountPeriod;

    @Column(name = "status")
    private String status;

    public Contract() {
    }

    /**
     * Checking if the contract is active.
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

    /**
     * Function return full name of period time for amount.
     *
     * @return Full name for AmmountPeriod.
     */
    public String getAmountPeriodBundled() {
        return AmountPeriod.getAmountPeriodFromCode(amountPeriod).getValue();
    }

    /**
     * Returns a full entry about the cash inflow in one String.
     *
     * @return Full string of cash inflow. Eg. '4500 zł netto'
     */
    public String getCashInflows() {
        return amount + " " + Currency.getCurrencyFromCode(currency).getShortcutValue() + " " + AmountType.getAmmountTypeFromCode(amountType).getValue();
    }

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Software getClientSystem() {
        return clientSystem;
    }

    public void setClientSystem(Software clientSystem) {
        this.clientSystem = clientSystem;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double ammount) {
        this.amount = ammount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String ammountType) {
        this.amountType = ammountType;
    }

    public String getAmountPeriod() {
        return amountPeriod;
    }

    public void setAmountPeriod(String amountPeriod) {
        this.amountPeriod = amountPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
