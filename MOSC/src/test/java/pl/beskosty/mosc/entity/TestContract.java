package pl.beskosty.mosc.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pl.beskosty.mosc.enums.AmountPeriod;
import pl.beskosty.mosc.enums.Status;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class TestContract {

    private final String INCORRECT_AMOUNT_PERIOD = "WEEK";

    @Test
    public void isActiveOnConstructor() {
        //Given
        Contract contract = new Contract();
        //When
        boolean isActive = contract.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithIncorrectStatus() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setStatus("ANY STATUS HERE?");
        boolean isActive = contract.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithCorrectStatus() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setStatus("A");
        boolean isActive = contract.isActive();
        //Then
        assertTrue(isActive);
    }

    @Test
    public void checkNullOnStatusBundledOnConstructor() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(null, contract.getStatusBundled());
    }

    @Test
    public void checkStatusBundledOnConstructor() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), contract.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithIncorrectStatus() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setStatus("ANY STATUS HERE?");
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), contract.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithCorrectStatus() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setStatus("A");
        //Then
        assertEquals(Status.ACTIVE.getValue(), contract.getStatusBundled());
    }

    @Test
    public void checkNullOnAmountPeriodBundledOnConstructor() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(null, contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledOnConstructorAsMonth() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(AmountPeriod.MONTHLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithIncorrectAmountPeriodAsMonth() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod(INCORRECT_AMOUNT_PERIOD);
        //Then
        assertNotEquals(AmountPeriod.MONTHLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithCorrectAmountPeriodAsMonth() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod("MONTH");
        //Then
        assertEquals(AmountPeriod.MONTHLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledOnConstructorAsQuarter() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(AmountPeriod.QUARTERLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithIncorrectAmountPeriodAsQuarter() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod(INCORRECT_AMOUNT_PERIOD);
        //Then
        assertNotEquals(AmountPeriod.QUARTERLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithCorrectAmountPeriodAsQuarter() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod("QUARTER");
        //Then
        assertEquals(AmountPeriod.QUARTERLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledOnConstructorAsYear() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(AmountPeriod.YEARLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithIncorrectAmountPeriodAsYear() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod(INCORRECT_AMOUNT_PERIOD);
        //Then
        assertNotEquals(AmountPeriod.YEARLY.getValue(), contract.getAmountPeriodBundled());
    }

    @Test
    public void checkAmountPeriodBundledWithCorrectAmountPeriodAsYear() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmountPeriod("YEAR");
        //Then
        assertEquals(AmountPeriod.YEARLY.getValue(), contract.getAmountPeriodBundled());
    }

}
