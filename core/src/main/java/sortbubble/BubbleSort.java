package sortbubble;

/**
 * Class BubbleSort.
 * Implements Bubble sort algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class BubbleSort {
    /**
     * Method sort an array.
     *
     * @param anArray Array.
     * @return Array.
     */
    public final int[] sort(final int[] anArray) {
        for (int i = anArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (anArray[j] > anArray[j + 1]) {
                    int t = anArray[j];
                    anArray[j] = anArray[j + 1];
                    anArray[j + 1] = t;
                }
            }
        }

        return anArray;
    }
}
