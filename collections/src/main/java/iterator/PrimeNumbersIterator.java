package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Class PrimeNumbersIterator.
 * Implements iterator for prime numbers.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 16.10.2018
 */
public class PrimeNumbersIterator implements Iterator {
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
    public PrimeNumbersIterator(final int[] pValues) {
        this.values = pValues;
    }

    /**
     * Method checks if the number is prime.
     *
     * @param pCurrentItem Number.
     * @return boolean.
     */
    public final boolean isPrime(final int pCurrentItem) {
        return (IntStream
                .rangeClosed(2, pCurrentItem)
                .filter(value -> pCurrentItem % value == 0)
                .count() == 1);
    }

    @Override
    public final boolean hasNext() {
        boolean result = false;
        int i = IntStream.range(this.currentIndex, this.values.length)
                .filter(value -> this.isPrime(this.values[value]))
                .findFirst().orElse(-1);
        if (i != -1) {
            this.currentIndex = i;
            result = true;
        }
        return result;
    }

    @Override
    public final Object next() {
        Object result = null;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        result = this.values[currentIndex];
        this.currentIndex++;
        return result;
    }
}
