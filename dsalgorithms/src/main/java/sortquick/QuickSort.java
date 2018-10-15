package sortquick;

/**
 * Class QuickSort.
 * Implements quick quickSort algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.10.2018
 */
public class QuickSort {
    /**
     * Method sorts the array.
     *
     * @param pArray Array/
     */
    public final void sort(final int[] pArray) {
        quickSort(pArray, 0, pArray.length - 1);
    }

    /**
     * Method implements quick sort algorithm.
     *
     * @param pArray Array.
     * @param pLow   Low.
     * @param pHigh  High.
     */

    public final void quickSort(
            final int[] pArray,
            final int pLow,
            final int pHigh) {

        if (pArray.length == 0) {
            return;
        }
        if (pLow >= pHigh) {
            return;
        }
        int middle = pLow + (pHigh - pLow) / 2;
        int opora = pArray[middle];
        int i = pLow, j = pHigh;
        while (i <= j) {
            while (pArray[i] < opora) {
                i++;
            }
            while (pArray[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = pArray[i];
                pArray[i] = pArray[j];
                pArray[j] = temp;
                i++;
                j--;
            }
        }
        if (pLow < j) {
            quickSort(pArray, pLow, j);
        }
        if (pHigh > i) {
            quickSort(pArray, i, pHigh);
        }
    }
}
