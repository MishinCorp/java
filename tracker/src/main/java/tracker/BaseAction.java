package tracker;

/**
 * Class BaseAction.
 * Implements UserAction interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public abstract class BaseAction implements UserAction {
    /**
     * Creation date.
     */
    public static final long DATE = 123L;
    /**
     * Action number.
     */
    private final int key;
    /**
     * Action name.
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param aKey  Action number.
     * @param aName Action name.
     */
    public BaseAction(final int aKey, final String aName) {
        this.key = aKey;
        this.name = aName;
    }

    /**
     * Method returns action number.
     *
     * @return key Action number.
     */
    @Override
    public final int key() {
        return this.key;
    }

    /**
     * Method informs on Action name.
     *
     * @return Message.
     */
    @Override
    public final String info() {
        return String.format("%s. %s", this.key + 1, this.name);
    }
}
