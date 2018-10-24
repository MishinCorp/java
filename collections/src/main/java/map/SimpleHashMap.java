package map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleHashMap.
 * Implements ISimpleHashMap.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public class SimpleHashMap<K, V> implements ISimpleHashMap<K, V> {
    /**
     * Percentage.
     */
    public static final int PERCENTAGE = 100;
    /**
     * Array size.
     */
    public static final int ARRAY_SIZE = 100;
    /**
     * Hashtable size.
     */
    private int arraySize = ARRAY_SIZE;
    /**
     * Storage.
     */
    private Object[] array = new Object[arraySize];

    /**
     * Capacity before rehashing.
     */
    private static final int MAX_CAP = 60;

    /**
     * Size.
     */
    private int size = 0;

    /**
     * Class Pair.
     * Stores Key-Value datas.
     *
     * @param <K> Key.
     * @param <V> Value.
     */
    private static class Pair<K, V> {
        /**
         * Key.
         */
        private K key;
        /**
         * Value.
         */
        private V value;

        /**
         * Constructor.
         *
         * @param pKey   Key.
         * @param pValue Value.
         */
        Pair(final K pKey, final V pValue) {
            this.key = pKey;
            this.value = pValue;
        }
    }

    @Override
    public final boolean insert(final K pKey, final V pValue) {
        boolean result;
        if ((PERCENTAGE * this.size / this.arraySize) > MAX_CAP) {
            this.rehash();
        }
        if (pKey.hashCode() < this.arraySize) {
            int hash;
            hash = pKey.hashCode() % this.arraySize;
            if (this.array[hash] == null) {
                Pair<K, V> pair = new Pair<>(pKey, pValue);
                this.array[hash] = pair;
                this.size++;
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public final V get(final K pKey) {
        V result = null;
        Pair<K, V> entry;
        for (Object hashItem : this.array) {
            if (hashItem != null) {
                entry = (Pair<K, V>) hashItem;
                if (entry.key.equals(pKey)) {
                    result = entry.value;
                    break;
                }
            }
        }
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public final boolean delete(final K pKey) {
        boolean result = false;
        Pair<K, V> entry;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                entry = (Pair<K, V>) this.array[i];
                if (entry.key.equals(pKey)) {
                    this.array[i] = null;
                    this.size--;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public final Iterator<K> iterator() {
        return new Iterator<K>() {
            private int count = 0;
            private int cycleStep = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;

                if (this.count < size) {
                    result = true;
                }
                return result;
            }

            @Override
            public K next() {
                K result = null;
                Pair<K, V> entry;
                if (this.hasNext()) {
                    for (int i = this.cycleStep; i < array.length; i++) {
                        if (array[i] != null) {
                            this.cycleStep = i + 1;
                            this.count++;
                            entry = (Pair<K, V>) array[i];
                            result = entry.key;
                            break;
                        }
                    }
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }

    /**
     * Method calculates a prime number.
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
     * @param pN N.
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
     * Method rehashes the table.
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
}
