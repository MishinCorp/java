package simplelambda;

/**
 * Class MathUtil.
 * Implements math operations.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 03.10.2018
 */
public final class MathUtil {
    /**
     * Constructor.
     */
    private MathUtil() {
    }

    /**
     * Method adds two args .
     *
     * @param left   Arg.
     * @param second Arg.
     * @return Double.
     */


    public static double add(final int left, final int second) {
        return left + second;
    }

    /**
     * Method divs two args.
     *
     * @param left   Args.
     * @param second Args.
     * @return Double.
     */
    public static double div(final int left, final int second) {
        return left / second;
    }
}
