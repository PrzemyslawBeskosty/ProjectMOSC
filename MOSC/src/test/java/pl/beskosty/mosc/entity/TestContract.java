package pl.beskosty.mosc.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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

}
