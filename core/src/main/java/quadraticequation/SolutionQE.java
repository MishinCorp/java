package quadraticequation;

/**
 * Class SolutionQE.
 * Implements Quadratic equation solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.10.2018
 */
public class SolutionQE {
    /**
     * D.
     */
    public static final int D = 4;

    /**
     * Methods solves an equation.
     *
     * @param pA Param A.
     * @param pB Param B.
     * @param pC Param C.
     * @return double[].
     */
    public final double[] solve(
            final double pA,
            final double pB,
            final double pC) {

        double[] result;
        double d = pB * pB - D * pA * pC;
        if (d > 0) {
            result = new double[2];
            result[0] = (-pB + Math.sqrt(d)) / 2 * pA;
            result[1] = (-pB - Math.sqrt(d)) / 2 * pA;
        } else if (d == 0) {
            result = new double[1];
            double x = -pB / (2 * pA);
            result[0] = x;
        } else {
            result = new double[0];
        }
        return result;
    }
}
