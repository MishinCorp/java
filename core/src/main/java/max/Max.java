package max;

/**
 * Class Max.
 * Calculates maximum.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class Max {
    /**
     * Method gets maximum.
     *
     * @param aFirst  Number.
     * @param aSecond Number.
     * @return Max.
     */
    public final int max(final int aFirst, final int aSecond) {
        int result;

        if (aFirst > aSecond) {
            result = aFirst;

        } else {
            result = aSecond;
        }

        return result;
    }

    /**
     * Method gets maximum.
     *
     * @param aFirst  Number.
     * @param aSecond Number.
     * @param aThird  Number.
     * @return Max.
     */
    public final int max(final int aFirst,
                         final int aSecond,
                         final int aThird) {

        return max(max(aFirst, aSecond), aThird);
    }
}
