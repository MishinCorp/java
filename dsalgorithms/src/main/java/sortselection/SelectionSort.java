package sortselection;

/**
 * Class SelectionSort.
 * Implements selection sort .
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.10.2018
 */
public class SelectionSort {
    /**
     * Method sorts the array.
     *
     * @param pArray Array.
     */
    public final void sort(final int[] pArray) {
        for (int i = 0; i < pArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < pArray.length; j++) {
                if (pArray[j] < pArray[min]) {
                    min = j;
                }
            }
            int temp = pArray[i];
            pArray[i] = pArray[min];
            pArray[min] = temp;
        }
    }
}
