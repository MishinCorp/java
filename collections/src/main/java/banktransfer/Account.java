package banktransfer;

/**
 * Class Account.
 * Implements entity Bank Account.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2018
 */
public class Account {
    /**
     * Requisites.
     */
    private String requisites;
    /**
     * Values.
     */
    private double values;

    /**
     * Constructor.
     *
     * @param pRequisites Requisites.
     * @param pValues     Values.
     */
    public Account(final String pRequisites, final int pValues) {
        this.requisites = pRequisites;
        this.values = pValues;
    }

    /**
     * Method gets values.
     *
     * @return values.
     */
    public final double getValues() {
        return this.values;
    }

    /**
     * Method sets values.
     *
     * @param pValues values.
     */
    public final void setValues(final double pValues) {
        this.values = pValues;
    }

    /**
     * Method gets requisites.
     *
     * @return Requisites.
     */
    public final String getRequisites() {
        return this.requisites;
    }

    /**
     * Method sets requisites.
     *
     * @param pRequisites requisites.
     */
    public final void setRequisites(final String pRequisites) {
        this.requisites = pRequisites;
    }
}
