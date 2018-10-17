package generics.store;

import generics.simplearray.SimpleArray;

/**
 * Abstract class AbstractStore.
 * Extends Base class.
 *
 * @param <T> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * STORAGE SIZE.
     */
    public static final int SIZE = 3;
    /**
     * Storage.
     */
    private SimpleArray array = new SimpleArray(SIZE);

    /**
     * Method adds an element.
     *
     * @param pModel Элемент.
     */
    @Override
    public final void add(final T pModel) {
        this.array.add(pModel);
    }

    /**
     * Method adds an element onto a specific position.
     *
     * @param pId    Index.
     * @param pModel Element.
     */
    @Override
    public final void replace(final String pId, final T pModel) {
        this.array.set(Integer.valueOf(pId), pModel);
    }

    /**
     * Method removes an element..
     *
     * @param pId Index.
     */
    @Override
    public final void delete(final String pId) {
        this.array.delete(Integer.valueOf(pId));
    }

    /**
     * Method searches an element by ID.
     *
     * @param pId ID.
     * @return Element.
     */
    @Override
    public final T findById(final String pId) {
        return (T) this.array.get(Integer.valueOf(pId));
    }
}
