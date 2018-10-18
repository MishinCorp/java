package simplearraylist;

/**
 * Interface SimpleContainer.
 * Declares simple array list.
 *
 * @param <E> Value.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.10.2018
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Method adds a value.
     *
     * @param pValue Value.
     */
    void add(E pValue);

    /**
     * Method gets a value.
     *
     * @param pIndex Index.
     * @return Value.
     */
    E get(int pIndex);
}
