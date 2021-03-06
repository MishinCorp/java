package simplestack;

import simplelinkedlist.SimpleLinkedList;

/**
 * Class SimpleStack.
 * Implements a simple stack.
 *
 * @param <T> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class SimpleStack<T> {
    /**
     * Storage.
     */
    private SimpleLinkedList<T> list = new SimpleLinkedList<>();

    /**
     * Method adds an element.
     *
     * @param pValue Element.
     */
    public final void push(final T pValue) {
        this.list.add(pValue);
    }

    /**
     * Methods retrieves an element and remove it.
     *
     * @return T Element.
     */
    public final T poll() {
        return this.list.removeTail();
    }
}
