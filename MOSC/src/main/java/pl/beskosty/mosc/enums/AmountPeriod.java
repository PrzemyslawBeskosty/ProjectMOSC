package pl.beskosty.mosc.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Przemek
 */
public enum AmountPeriod {
    MONTHLY("MONTH", "Miesięcznie"),
    QUARTERLY("QUARTER", "Kwartalnie"),
    YEARLY("YEAR", "Rocznie"),
    UNDEFINED("X", "Nieokreślony");

    private String code;
    private String value;

    private AmountPeriod(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     *
     * @return One character code for the given settlement.
     */
    public String getCode() {
        return code;
    }

    /**
     *
     *
     * @return Full name for the given settlement.
     */
    public String getValue() {
        return value;
    }

    /**
     * The function returns the settlement based on the received code.
     *
     * @param code The code for which we are looking for settlement.
     * @return Settlement object.
     */
    public static AmountPeriod getAmountPeriodFromCode(String code) {
        if (code == null) {
            return AmountPeriod.UNDEFINED;
        }
        switch (code) {
            case "MONTH":
                return AmountPeriod.MONTHLY;
            case "QUARTER":
                return AmountPeriod.QUARTERLY;
            case "YEAR":
                return AmountPeriod.YEARLY;
            default:
                return AmountPeriod.UNDEFINED;
        }
    }

    /**
     * Returns the map as: key is ENUM.getCode (), value is ENUM.getValue ().
     *
     * @return Map from Settlement. Everything included except the option
     * 'UNDEFINED'.
     */
    public static Map<String, String> getAmountPeriodMap() {
        Map<String, String> map = new HashMap<>();
        map.put(AmountPeriod.MONTHLY.getCode(), AmountPeriod.MONTHLY.getValue());
        map.put(AmountPeriod.QUARTERLY.getCode(), AmountPeriod.QUARTERLY.getValue());
        map.put(AmountPeriod.YEARLY.getCode(), AmountPeriod.YEARLY.getValue());
        return map;
    }

    @Override
    public String toString() {
        return getCode();
    }

}
