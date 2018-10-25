package euclidgcd;

/**
 * Class Solution.
 * Implements euclid algorithm to get GCD — greatest common divisor.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public class Solution {
    /**
     * Method calculates the solution by loop.
     *
     * @param pA A.
     * @param pB B.
     * @return int Result.
     */
    public final int loop(final int pA, final int pB) {
        int a = pA;
        int b = pB;
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    /**
     * Method calculates the solution by recursion.
     *
     * @param pA A.
     * @param pB B.
     * @return int Result.
     */
    public final int recur(final int pA, final int pB) {
        if (pB == 0) {
            return pA;
        }
        return recur(pB, pA % pB);
    }
}
