package generics.store;

/**
 * Abstract class Base.
 * Implements an element entity
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public abstract class Base {
    /**
     * ID.
     */
    private final String id;

    /**
     * Constructor.
     *
     * @param pId ID.
     */
    protected Base(final String pId) {
        this.id = pId;
    }

    /**
     * Method gets an id.
     *
     * @return String.
     */
    public final String getId() {
        return this.id;
    }
}
