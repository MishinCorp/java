package simplearraylist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleList.
 * Implements SimpleContainer.
 *
 * @param <E> Value.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.10.2018
 */
public class SimpleList<E> implements SimpleContainer<E> {
    /**
     * Storage.
     */
    private Object[] container;
    /**
     * Size.
     */
    private int size = 2;
    /**
     * Delta.
     */
    private int delta = 2;
    /**
     * List index.
     */
    private int listIndex = 0;
    /**
     * Count of modifications.
     */
    private int modCount = 0;

    /**
     * Constructor.
     */
    public SimpleList() {
        this.container = new Object[this.size];
    }

    @Override
    public final void add(final E pValue) {
        if (this.size <= this.listIndex) {
            Object[] newList = new Object[this.size + this.delta];
            System.arraycopy(this.container, 0, newList, 0, this.size);
            this.size = this.listIndex + this.delta;
            this.container = newList;
            this.modCount++;
        }
        this.container[this.listIndex++] = pValue;
    }

    @Override
    public final E get(final int pIndex) {
        return (E) this.container[pIndex];
    }

    @Override
    public final Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.count < listIndex) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!(this.expectedModCount == modCount)) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[this.count++];
            }
        };
    }
}
