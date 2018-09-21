package removeduplicates;

import java.util.Arrays;

/**
 * Class Max.
 * Remove duplicates in an array.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 21.09.2018
 */
public class ArrayDuplicate {
    /**
     * Method removes duplicates.
     *
     * @param anArray Array.
     * @return array Array.
     */
    public final String[] remove(final String[] anArray) {
        int unique = anArray.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (anArray[out].equals(anArray[in])) {
                    anArray[in] = anArray[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(anArray, unique);
    }
}
