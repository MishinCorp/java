package setbasedonarray;

/**
 * Interface SimpleSet.
 * Declares Set.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public interface ISimpleSet<E> extends Iterable<E> {
    /**
     * Method adds an element.
     *
     * @param e Element.
     */
    void add(E e);
}
