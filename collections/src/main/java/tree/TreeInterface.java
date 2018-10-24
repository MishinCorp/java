package tree;

import java.util.Optional;

/**
 * Interface TreeInterface.
 * Declares simple Tree.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public interface TreeInterface<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Method adds an element.
     *
     * @param pParent Parent.
     * @param pChild  Child.
     * @return boolean.
     */
    boolean add(final E pParent, final E pChild);

    /**
     * Method searches for the element.
     *
     * @param pValue Element.
     * @return Optional with result.
     */
    Optional<Node<E>> findBy(final E pValue);
}
