package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Class EvenNumbersIterator.
 * Implements iterator for even numbers.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 16.10.2018
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * Values.
     */
    private final int[] values;
    /**
     * Current index.
     */
    private int currentIndex = 0;

    /**
     * Constructor.
     *
     * @param pValues Values.
     */
    public EvenNumbersIterator(final int[] pValues) {
        this.values = pValues;
    }

    @Override
    public final boolean hasNext() {
        boolean result = false;
        int i = IntStream.range(this.currentIndex, this.values.length)
                .filter(value -> this.values[value] % 2 == 0)
                .findFirst().orElse(-1);
        if (i != -1) {
            this.currentIndex = i;
            result = true;
        }
        return result;
    }

    @Override
    public final Object next() {
        Object result;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        result = this.values[currentIndex];
        this.currentIndex++;
        return result;
    }
}
