package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorOfIterators.
 * Implements Iterator out of iterators.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class IteratorOfIterators {
    /**
     * Method converts iterators into a single one.
     *
     * @param pIt Iterators.
     * @return Iterator.
     */
    public final Iterator<Integer> convert(
            final Iterator<Iterator<Integer>> pIt) {

        return new Iterator<Integer>() {
            private Iterator currentIterator = pIt.next();

            @Override
            public boolean hasNext() {
                return this.currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                Integer result;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                result = (int) this.currentIterator.next();
                if (!this.hasNext() && pIt.hasNext()) {
                    this.currentIterator = pIt.next();
                }
                return result;
            }
        };
    }
}
