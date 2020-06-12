package pl.beskosty.mosc.enums;

/**
 *
 * @author Przemek
 */
public enum Status {
    ACTIVE("A", "Aktywny"),
    NOT_ACTIVE("N", "Nieaktywny"),
    UNDEFINED("X", "Nieokreślony");

    private String code;
    private String value;

    private Status(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     *
     * @return One character code for the given status.
     */
    public String getCode() {
        return code;
    }

    /**
     *
     *
     * @return Full name for the given status.
     */
    public String getValue() {
        return value;
    }

    /**
     * The function returns the status based on the received code.
     *
     * @param code The code for which we are looking for status.
     * @return Status object.
     */
    public static Status getStatusFromCode(String code) {
        if (code == null) {
            return Status.UNDEFINED;
        }
        switch (code) {
            case "A":
                return Status.ACTIVE;
            case "N":
                return Status.NOT_ACTIVE;
            default:
                return Status.UNDEFINED;
        }
    }

    @Override
    public String toString() {
        return getCode();
    }

}
