package setbasedonhashtable;

import java.util.Arrays;

/**
 * Class SimpleHashSet.
 * Implements IHashSet.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public class SimpleHashSet<E> implements IHashSet<E> {
    /**
     * Hash-table size.
     */
    public static final int ARRAY_SIZE = 3;
    /**
     * Percentage.
     */
    public static final int PERCENTAGE = 100;
    /**
     * Hash-table size.
     */
    private int arraySize = ARRAY_SIZE;
    /**
     * Storage.
     */
    private Object[] array = new Object[arraySize];
    /**
     * Capacity percentage before rehashing.
     */
    private static final int MAX_CAP = 60;
    /**
     * Size.
     */
    private int size = 0;

    @Override
    public final boolean add(final E pE) {
        boolean result = false;
        if ((PERCENTAGE * this.size / arraySize) > MAX_CAP) {
            this.rehash();
        }
        if (pE.hashCode() < arraySize) {
            int hash;
            hash = pE.hashCode() % arraySize;
            this.array[hash] = pE;
            this.size++;
            result = true;

        }
        return result;
    }

    /**
     * Method calculate the prime number.
     *
     * @param pNumber Number.
     * @return Prime number.
     */
    private int getPrime(final int pNumber) {
        int n = pNumber;
        int result = 0;
        do {
            if (isPrime(n)) {
                result = n;
            } else {
                n++;
            }
        } while (result == 0);
        return result;
    }

    /**
     * Method checks if the number is prime.
     *
     * @param pN Number.
     * @return boolean.
     */
    private boolean isPrime(final int pN) {
        boolean result = true;
        for (int i = 2; i < pN; i++) {
            if (pN % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Method rehashes the hash-table.
     */
    private void rehash() {
        this.arraySize = getPrime(this.arraySize * 2);
        Object[] newArray = new Object[this.arraySize];
        int newHash;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                newHash = this.array[i].hashCode() % this.arraySize;
                newArray[newHash] = this.array[i];
            }
        }
        this.array = newArray;
    }

    @Override
    public final boolean contains(final E pE) {
        return Arrays.stream(this.array)
                .anyMatch(item -> item != null && item.equals(pE));
    }

    @Override
    public final boolean remove(final E pE) {
        boolean result = false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                if (this.array[i].equals(pE)) {
                    this.array[i] = null;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
