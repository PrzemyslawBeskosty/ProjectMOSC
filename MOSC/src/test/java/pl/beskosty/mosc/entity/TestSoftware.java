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
        Software software = new Software();
        //When
        software.setStatus("ANY STATUS HERE?");
        boolean isActive = software.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithCorrectStatus() {
        //Given
        Software software = new Software();
        //When
        software.setStatus("A");
        boolean isActive = software.isActive();
        //Then
        assertTrue(isActive);
    }

    @Test
    public void checkNullOnStatusBundledOnConstructor() {
        //Given
        Software software = new Software();
        //Then
        assertNotEquals(null, software.getStatusBundled());
    }

    @Test
    public void checkStatusBundledOnConstructor() {
        //Given
        Software software = new Software();
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), software.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithIncorrectStatus() {
        //Given
        Software software = new Software();
        //When
        software.setStatus("ANY STATUS HERE?");
        boolean isActive = software.isActive();
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), software.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithCorrectStatus() {
        //Given
        Software software = new Software();
        //When
        software.setStatus("A");
        boolean isActive = software.isActive();
        //Then
        assertEquals(Status.ACTIVE.getValue(), software.getStatusBundled());
    }

}
