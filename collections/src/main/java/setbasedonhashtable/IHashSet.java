package setbasedonhashtable;

/**
 * Interface IHashSet.
 * Declares set based in hash-table.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public interface IHashSet<E> {
    /**
     * Method adds an element.
     *
     * @param pE Element.
     * @return boolean.
     */
    boolean add(E pE);

    /**
     * Method checks if the collection contains the element.
     *
     * @param pE Element.
     * @return boolean.
     */
    boolean contains(E pE);

    /**
     * Method removes the element.
     *
     * @param pE Element.
     * @return boolean.
     */
    boolean remove(E pE);
}
