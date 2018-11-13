package userstorage;

/**
 * Class User.
 * Implements entity User.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public class User {
    /**
     * ID.
     */
    private int id;
    /**
     * Amount.
     */
    private int amount;

    /**
     * Constructor.
     *
     * @param pId     User ID.
     * @param pAmount Amount.
     */
    public User(final int pId, final int pAmount) {
        this.id = pId;
        this.amount = pAmount;
    }

    /**
     * Method gets ID.
     *
     * @return ID.
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Method gets amount.
     *
     * @return Amount.
     */
    public final int getAmount() {
        return this.amount;
    }

    /**
     * Method sets amount.
     *
     * @param pAmount Amount.
     */
    public final void setAmount(final int pAmount) {
        this.amount = pAmount;
    }
}
