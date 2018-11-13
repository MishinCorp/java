package isprime;

/**
 * Class Solution.
 * Implements entity Solution to check if the number is prime.
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
    public final boolean isPrime(final int pN) {
        boolean result = false;
        int count = 1;
        for (int i = 1; i <= (pN / 2); i++) {
            if (pN % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            result = true;
        }
        return result;
    }
}
