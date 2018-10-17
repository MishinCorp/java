package generics.store;

/**
 * Interface Store.
 * Describes a store entity.
 *
 * @param <T> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public interface Store<T extends Base> {
    /**
     * Method adds an element.
     *
     * @param pModel Element.
     */
    void add(final T pModel);

    /**
     * Method adds an element onto a specific position..
     *
     * @param pId    ID.
     * @param pModel Element.
     */
    void replace(final String pId, final T pModel);

    /**
     * Method removes an element.
     *
     * @param pId ID.
     */
    void delete(final String pId);

    /**
     * Method searches an element by ID.
     *
     * @param pId ID.
     * @return Element.
     */
    T findById(final String pId);
}
