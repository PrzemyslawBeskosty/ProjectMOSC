package pl.beskosty.mosc.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class TestAmountType {

    public TestAmountType() {
    }

    /**
     * Enum size is all possible enums. Map size is all possible enums - 1
     * (UNDEFINED). Compare both of this sizes.
     */
    @Test
    public void compareMapSizeWithEnumSize() {
        //Given
        int enumSize = AmountType.values().length;
        int mapSize = AmountType.getAmountTypeMap().size();
        //Then
        assertEquals(enumSize, mapSize + 1);
    }

}
