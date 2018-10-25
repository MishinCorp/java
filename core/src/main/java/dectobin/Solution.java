package dectobin;

/**
 * Class Solution.
 * Implements decimal to binary conversion.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public class Solution {
    /**
     * Method computes binary.
     *
     * @param pN N.
     * @return String.
     */
    public final String toBinaryStd(final int pN) {
        return Integer.toBinaryString(pN);
    }

    /**
     * Method computes binary.
     *
     * @param pN N.
     * @return String.
     */
    public final String toBinRadix(final int pN) {
        return Integer.toString(pN, 2);
    }

    /**
     * Method computes binary.
     *
     * @param pN N.
     * @return String.
     */
    public final String toBinCustom(final int pN) {
        int p = pN;
        int b;
        StringBuilder temp = new StringBuilder();
        while (p != 0) {
            b = p % 2;
            temp.append(b);
            p = p / 2;
        }
        return temp.reverse().toString();
    }
}
