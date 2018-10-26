package countofdev;

/**
 * Class Solution.
 * Implements entity Solution to compute the quantity of devisions the N number.
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
    public final int count(final int pN) {
        int result = 1;
        for (int i = 1; i <= (pN / 2); i++) {
            if (pN % i == 0) {
                result++;
            }
        }
        return result;
    }
}
