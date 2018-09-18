package array;

/**
 * Class ReverseArray.
 * Reverses an array.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class ReverseArray {
    /**
     * Methods reverse an array.
     *
     * @param anArray Array.
     * @return Array.
     */
    public final int[] back(final int[] anArray) {
        for (int i = 0; i < anArray.length / 2; i++) {
            int tempVar = anArray[i];
            anArray[i] = anArray[anArray.length - i - 1];
            anArray[anArray.length - i - 1] = tempVar;
        }

        return anArray;
    }
}
