package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node.
 * Implements a node.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public class Node<E extends Comparable<E>> {
    /**
     * Storage.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Value.
     */
    private final E value;

    /**
     * Constructor.
     *
     * @param pValue Value.
     */
    public Node(final E pValue) {
        this.value = pValue;
    }

    /**
     * Method adds a node child.
     *
     * @param pChild Node child.
     */
    public final void add(final Node<E> pChild) {
        this.children.add(pChild);
    }

    /**
     * Method gets a list of all children.
     *
     * @return List.
     */
    public final List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Method checks children if they are equal.
     *
     * @param pThat That child..
     * @return boolean.
     */
    public final boolean eqValue(final E pThat) {
        return this.value.compareTo(pThat) == 0;
    }

    /**
     * Method gets a value from the Node.
     *
     * @return Value.
     */
    public final E getValue() {
        return this.value;
    }
}
