package pl.beskosty.mosc.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Przemek
 */
public enum AmountType {
    NETTO("NET", "netto"),
    BRUTTO("BRU", "brutto"),
    UNDEFINED("X", "Nieokreślony");

    private String code;
    private String value;

    private AmountType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     *
     * @return One character code for the given amount type.
     */
    public String getCode() {
        return code;
    }

    /**
     *
     *
     * @return Full name for the given amount type.
     */
    public String getValue() {
        return value;
    }

    /**
     * The function returns the ammount type based on the received code.
     *
     * @param code The code for which we are looking for amount type.
     * @return AmountType object.
     */
    public static AmountType getAmmountTypeFromCode(String code) {
        if (code == null) {
            return AmountType.UNDEFINED;
        }
        switch (code) {
            case "NET":
                return AmountType.NETTO;
            case "BRU":
                return AmountType.BRUTTO;
            default:
                return AmountType.UNDEFINED;
        }
    }

    /**
     * Returns the map as: key is ENUM.getCode (), value is ENUM.getValue ().
     *
     * @return Map from AmountType. Everything included except the option 'UNDEFINED'.
     */
    public static Map<String, String> getAmountTypeMap() {
        Map<String, String> map = new HashMap<>();
        map.put(AmountType.BRUTTO.getCode(), AmountType.BRUTTO.getValue());
        map.put(AmountType.NETTO.getCode(), AmountType.NETTO.getValue());
        return map;
    }

    @Override
    public String toString() {
        return getCode();
    }

}
