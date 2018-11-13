package sumfromoneton;

/**
 * Class Solution.
 * Implements entity Solution to compute the sum from 1 to N.
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
    public final int sum(final int pN) {
        int result = 0;
        for (int i = 0; i <= pN; i++) {
            result += i;
        }
        return result;
    }
}
