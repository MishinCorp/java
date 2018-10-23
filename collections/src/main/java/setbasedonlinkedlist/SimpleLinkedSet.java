package setbasedonlinkedlist;

import setbasedonarray.ISimpleSet;
import simplelinkedlist.SimpleLinkedList;

import java.util.Iterator;

/**
 * Class SimpleLinkedSet.
 * Implements set based on linked list.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public class SimpleLinkedSet<E> implements ISimpleSet<E> {
    /**
     * Storage.
     */
    private SimpleLinkedList<E> list = new SimpleLinkedList<>();
    /**
     * Length.
     */
    private int length = 0;

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
        return list.iterator();
    }
}
