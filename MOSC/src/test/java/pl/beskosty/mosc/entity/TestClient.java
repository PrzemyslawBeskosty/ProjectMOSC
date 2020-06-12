package pl.beskosty.mosc.entity;

import org.junit.jupiter.api.Assertions;
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
public class TestClient {

    public TestClient() {
    }

    @Test
    public void isActiveOnConstructor() {
        //Given
        Client client = new Client();
        //When
        boolean isActive = client.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithIncorrectStatus() {
        //Given
        Client client = new Client();
        //When
        client.setStatus("ANY STATUS HERE?");
        boolean isActive = client.isActive();
        //Then
        assertFalse(isActive);
    }

    @Test
    public void isActiveWithCorrectStatus() {
        //Given
        Client client = new Client();
        //When
        client.setStatus("A");
        boolean isActive = client.isActive();
        //Then
        assertTrue(isActive);
    }

    @Test
    public void checkNullOnStatusBundledOnConstructor() {
        //Given
        Client client = new Client();
        //Then
        assertNotEquals(null, client.getStatusBundled());
    }

    @Test
    public void checkStatusBundledOnConstructor() {
        //Given
        Client client = new Client();
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), client.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithIncorrectStatus() {
        //Given
        Client client = new Client();
        //When
        client.setStatus("ANY STATUS HERE?");
        boolean isActive = client.isActive();
        //Then
        assertNotEquals(Status.ACTIVE.getValue(), client.getStatusBundled());
    }

    @Test
    public void checkStatusBundledWithCorrectStatus() {
        //Given
        Client client = new Client();
        //When
        client.setStatus("A");
        boolean isActive = client.isActive();
        //Then
        assertEquals(Status.ACTIVE.getValue(), client.getStatusBundled());
    }

}
