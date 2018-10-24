package map;

/**
 * Interface ISimpleHashMap.
 * Declares simple HashMap.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public interface ISimpleHashMap<K, V> extends Iterable<K> {
    /**
     * Method adds an element.
     *
     * @param pKey   Key.
     * @param pValue Value.
     * @return boolean.
     */
    boolean insert(final K pKey, final V pValue);

    /**
     * Method gets the value..
     *
     * @param pKey Key.
     * @return Value.
     */
    V get(final K pKey);

    /**
     * Method removes the value.
     *
     * @param pKey Key.
     * @return boolean.
     */
    boolean delete(final K pKey);
}
