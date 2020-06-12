package pl.beskosty.mosc.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Przemek
 */
public enum Currency {
    PLN("PLN", "Złoty", "zł"),
    USD("USD", "Dolar", "$"),
    UNDEFINED("X", "Nieokreślony", "???");

    private String code;
    private String value;
    private String shortcutValue;

    private Currency(String code, String value, String shortcutValue) {
        this.code = code;
        this.value = value;
        this.shortcutValue = shortcutValue;
    }

    /**
     * @return One character code for the given currency. Eg. 'PLN'
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Full name for the given currency. Eg. 'Złoty'
     */
    public String getValue() {
        return value;
    }

    /**
     * @return Shortcut value for the given currency. Eg. 'zł'
     */
    public String getShortcutValue() {
        return shortcutValue;
    }

    /**
     * The function returns the currency based on the received code.
     *
     * @param code The code for which we are looking for currency.
     * @return Currency object.
     */
    public static Currency getCurrencyFromCode(String code) {
        if (code == null) {
            return Currency.UNDEFINED;
        }
        switch (code) {
            case "PLN":
                return Currency.PLN;
            case "USD":
                return Currency.USD;
            default:
                return Currency.UNDEFINED;
        }
    }

    /**
     * Returns the map as: key is ENUM.getCode (), value is ENUM.getValue ().
     *
     * @return Map from Currency. Everything included except the option
     * 'UNDEFINED'.
     */
    public static Map<String, String> getCurrencyMap() {
        Map<String, String> map = new HashMap<>();
        map.put(Currency.PLN.getCode(), Currency.PLN.getValue());
        map.put(Currency.USD.getCode(), Currency.USD.getValue());
        return map;
    }

    @Override
    public String toString() {
        return getCode();
    }

}
