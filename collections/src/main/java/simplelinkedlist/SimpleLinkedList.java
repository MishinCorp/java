package simplelinkedlist;

import simplearraylist.SimpleContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleLinkedList.
 * Implements simple linked list..
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 19.10.2018
 */
public class SimpleLinkedList<E> implements SimpleContainer<E> {
    /**
     * Size.
     */
    private int size = 0;
    /**
     * Node first.
     */
    private Node<E> first;
    /**
     * Node last.
     */
    private Node<E> last;
    /**
     * Modifications count.
     */
    private int modCount = 0;

    /**
     * Class Node.
     * Implements list node.
     *
     * @param <E> Element.
     */
    private static class Node<E> {
        /**
         * Element.
         */
        private E item;
        /**
         * Next node.
         */
        private Node<E> next;
        /**
         * Previous node.
         */
        private Node<E> prev;

        /**
         * Constructor.
         *
         * @param pPrev    Previous.
         * @param pElement Element.
         * @param pNext    Next.
         */
        Node(final Node<E> pPrev, final E pElement, final Node<E> pNext) {
            this.item = pElement;
            this.next = pNext;
            this.prev = pPrev;
        }
    }

    @Override
    public final void add(final E pValue) {
        if (this.size == 0) {
            Node<E> nodeStart = new Node<>(null, pValue, null);
            this.first = nodeStart;
            this.last = nodeStart;
        } else {
            Node<E> newNode = new Node<>(this.last, pValue, null);
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
        this.modCount++;
    }

    @Override
    public final E get(final int pIndex) {
        if (!((pIndex >= 0) && (pIndex < this.size))) {
            throw new NoSuchElementException();
        }
        Node<E> currentNode = this.first;
        for (int i = 0; i < pIndex; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    @Override
    public final Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;
            private int expectedModCount = modCount;
            private Node<E> currentNode = null;

            @Override
            public boolean hasNext() {
                return (count < size);
            }

            @Override
            public E next() {
                if (!(this.expectedModCount == modCount)) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (currentNode == null) {
                    currentNode = first;
                } else {
                    currentNode = currentNode.next;
                }
                count++;
                return currentNode.item;
            }
        };
    }

    /**
     * Method gets the first element.
     *
     * @return Element.
     */
    public final E removeHead() {
        if (!(size > 0)) {
            throw new NoSuchElementException();
        }
        E result = this.first.item;
        this.first = this.first.next;
        this.size--;
        this.modCount++;
        return result;
    }

    /**
     * Method gets the last element.
     *
     * @return Element.
     */
    public final E removeTail() {
        if (!(size > 0)) {
            throw new NoSuchElementException();
        }
        E result = this.last.item;
        this.last = this.last.prev;
        this.size--;
        this.modCount++;
        return result;
    }
}
