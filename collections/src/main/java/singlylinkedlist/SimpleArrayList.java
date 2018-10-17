package singlylinkedlist;

/**
 * Class SimpleArrayList.
 * Implements singly linked list.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class SimpleArrayList<E> {
    /**
     * Size.
     */
    private int size;
    /**
     * First element.
     */
    private Node<E> first;

    /**
     * Class Node.
     * Stores data.
     *
     * @param <E> Element.
     */
    private static class Node<E> {
        /**
         * Data.
         */
        private E data;
        /**
         * Next Node.
         */
        private Node<E> next;

        /**
         * Constructor.
         *
         * @param pData Data.
         */
        Node(final E pData) {
            this.data = pData;
        }
    }

    /**
     * Method adds an element.
     *
     * @param pData Data.
     */
    public final void add(final E pData) {
        Node<E> newLink = new Node<>(pData);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method deletes the first element.
     *
     * @return E Element.
     */
    public final E delete() {
        E result = this.first.data;
        this.first = this.first.next;
        size--;
        return result;
    }

    /**
     * Method gets the element by index.
     *
     * @param pIndex Index.
     * @return E Element.
     */
    public final E get(final int pIndex) {
        Node<E> result = this.first;
        for (int i = 0; i < pIndex; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Method gets list size.
     *
     * @return Size.
     */
    public final int getSize() {
        return this.size;
    }
}
