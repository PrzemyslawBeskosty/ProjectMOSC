package pl.beskosty.mosc.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pl.beskosty.mosc.enums.Status;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class TestContract {

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

}
