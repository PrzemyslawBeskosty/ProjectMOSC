package pl.beskosty.mosc.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class TestSoftware {

    public TestSoftware() {
    }

    @Test
    public void isActiveOnConstructor() {
        //Given
        Software software = new Software();
        //When
        boolean isActive = software.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithIncorrectStatus() {
        //Given
        Software client = new Software();
        //When
        client.setStatus("ANY STATUS HERE?");
        boolean isActive = client.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithCorrectStatus() {
        //Given
        Software client = new Software();
        //When
        client.setStatus("A");
        boolean isActive = client.isActive();
        //Then
        assertTrue(isActive);
    }

}
