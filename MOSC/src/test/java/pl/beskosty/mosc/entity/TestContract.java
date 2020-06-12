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

    @Test
    public void checkNullOnCashInflowsOnConstructor() {
        //Given
        Contract contract = new Contract();
        //Then
        assertNotEquals(null, contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsOnConstructor() {
        //Given
        Contract contract = new Contract();
        //Then
        assertEquals("0,00 zł Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithAmountAsInt() {
        //Given
        Contract contract = new Contract();
        //Then
        contract.setAmount(100);
        //Then
        assertEquals("100,00 zł Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithAmountAsThreeDecimalDoubleAboveHalf() {
        //Given
        Contract contract = new Contract();
        //Then
        contract.setAmount(1.506);
        //Then
        assertEquals("1,51 zł Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithAmountAsThreeDecimalDoubleOnHalf() {
        //Given
        Contract contract = new Contract();
        //Then
        contract.setAmount(1.505);
        //Then
        assertEquals("1,50 zł Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithAmountAsThreeDecimalDoubleBelowHalf() {
        //Given
        Contract contract = new Contract();
        //Then
        contract.setAmount(1.504);
        //Then
        assertEquals("1,50 zł Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithIncorrectCurrency() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setCurrency("EURO");
        //Then
        assertEquals("0,00 ? Nieokreślony", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithCorrectValuesOne() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmount(100);
        contract.setCurrency("USD");
        contract.setAmountType("BRU");
        //Then
        assertEquals("100,00 $ brutto", contract.getCashInflows());
    }

    @Test
    public void checkCashInflowsWithCorrectValuesTwo() {
        //Given
        Contract contract = new Contract();
        //When
        contract.setAmount(0.01);
        contract.setCurrency("PLN");
        contract.setAmountType("NET");
        //Then
        assertEquals("0,01 zł netto", contract.getCashInflows());
    }

}
