package arithmetic;

/**
 * Class SimpleCalc.
 * Class for arithmetic methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2018
 */
public final class SimpleCalc {
    /**
     * Method sums args.
     *
     * @param aNumA Param.
     * @param aNumB Param.
     * @return Result.
     */
    public int sum(final int aNumA, final int aNumB) {
        if (aNumA == 0 && aNumB == 0) {
            throw new RuntimeException("Your args are zeros.");
        }

        return aNumA + aNumB;
    }
}
