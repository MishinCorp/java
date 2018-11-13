package multifromoneton;

/**
 * Class Solution.
 * Implements entity Solution to compute the multiplication from 1 to N.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.10.2018
 */
public class Solution {
    /**
     * Method computes the result.
     *
     * @param pN N.
     * @return int Result.
     */
    public final int multi(final int pN) {
        int result = 1;
        for (int i = 1; i <= pN; i++) {
            result *= i;
        }
        return result;
    }
}
