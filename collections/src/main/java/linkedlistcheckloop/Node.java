package linkedlistcheckloop;

/**
 * Class Node.
 * Implements a node.
 *
 * @param <T> Vaue.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class Node<T> {
    /**
     * Value.
     */
    private T value;
    /**
     * Next node.
     */
    private Node<T> next;

    /**
     * Constructor.
     *
     * @param pValue Value.
     */
    public Node(final T pValue) {
        this.value = pValue;
    }

    /**
     * Method gets the value.
     *
     * @return T Value.
     */
    public final T getValue() {
        return value;
    }

    /**
     * Method sets the value.
     *
     * @param pValue Value.
     */
    public final void setValue(final T pValue) {
        this.value = pValue;
    }

    /**
     * Method gets the next node.
     *
     * @return Node.
     */
    public final Node<T> getNext() {
        return next;
    }

    /**
     * Method sets the next node.
     *
     * @param pNext Next node.
     */
    public final void setNext(final Node<T> pNext) {
        this.next = pNext;
    }
}
