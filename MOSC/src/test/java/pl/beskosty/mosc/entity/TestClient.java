package pl.beskosty.mosc.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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

}
