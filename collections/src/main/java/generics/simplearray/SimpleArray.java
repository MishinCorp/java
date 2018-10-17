package generics.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray.
 * Implements a simple container.
 *
 * @param <T> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Storage.
     */
    private Object[] objects;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     *
     * @param pSize Size.
     */
    public SimpleArray(final int pSize) {
        this.objects = new Object[pSize];
    }

    /**
     * Method adds an element.
     *
     * @param pModel Элемент.
     */
    public final void add(final T pModel) {
        this.objects[this.index++] = pModel;
    }

    /**
     * Method adds an element onto a specific position.
     *
     * @param pIndex Index.
     * @param pModel Element.
     */
    public final void set(final int pIndex, final T pModel) {
        this.objects[pIndex] = pModel;
    }

    /**
     * Method removes an element..
     *
     * @param pIndex Index.
     */
    public final void delete(final int pIndex) {
        if (!(this.objects.length - 1 >= pIndex) && (pIndex >= 0)) {
            throw new NoSuchElementException();
        }
        System.arraycopy(
                this.objects,
                pIndex + 1,
                this.objects, pIndex,
                this.objects.length - pIndex - 1);

        this.objects[this.index - 1] = null;
    }

    /**
     * Method gets an element..
     *
     * @param pPosition Position.
     * @return T Element.
     */
    public final T get(final int pPosition) {
        return (T) this.objects[pPosition];
    }

    @Override
    public final Iterator<T> iterator() {
        Iterator it = new Iterator() {
            private int itIndex = 0;
            private Object[] itObjects = objects;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.itIndex < this.itObjects.length) {
                    if (this.itObjects[this.itIndex] != null) {
                        result = true;
                    }
                }
                return result;
            }

            @Override
            public Object next() {
                Object result;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                result = this.itObjects[this.itIndex++];
                return result;
            }
        };
        return it;
    }
}
