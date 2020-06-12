package pl.beskosty.mosc.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class TestCurrency {

    public TestCurrency() {
    }

    /**
     * Enum size is all possible enums. Map size is all possible enums - 1
     * (UNDEFINED). Compare both of this sizes.
     */
    @Test
    public void compareMapSizeWithEnumSize() {
        //Given
        int enumSize = Currency.values().length;
        int mapSize = Currency.getCurrencyMap().size();
        //Then
        assertEquals(enumSize, mapSize + 1);
    }

}
