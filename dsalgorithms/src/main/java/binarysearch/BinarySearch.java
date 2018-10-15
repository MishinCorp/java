package binarysearch;

/**
 * Class BinarySearch.
 * Implements binary search algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.10.2018
 */
public class BinarySearch {
    /**
     * Method searches the value.
     *
     * @param pArray Array.
     * @param pValue Value.
     * @return boolean.
     */
    public final boolean search(final int[] pArray, final int pValue) {
        boolean result = false;
        int low = 0;
        int high = pArray.length - 1;
        while (low <= high) {
            int mid = low + high;
            int guess = pArray[mid];
            if (guess == pValue) {
                result = true;
                break;
            } else if (guess > pValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
