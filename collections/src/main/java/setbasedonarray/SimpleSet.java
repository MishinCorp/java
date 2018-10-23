package setbasedonarray;

import simplearraylist.SimpleList;

import java.util.Iterator;

/**
 * Class SimpleSet
 * Implements ISimpleSet.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public class SimpleSet<E> implements ISimpleSet<E> {
    /**
     * Storage.
     */
    private SimpleList<E> list = new SimpleList<>();
    /**
     * Length.
     */
    private int length = 0;

    /**
     * Method adds an element.
     *
     * @param pE Element.
     */
    @Override
    public final void add(final E pE) {
        boolean match = false;
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            if (pE.equals(it.next())) {
                match = true;
                break;
            }
        }
        if (!match) {
            this.list.add(pE);
            this.length++;
        }
    }

    @Override
    public final Iterator<E> iterator() {
        return this.list.iterator();
    }
}
