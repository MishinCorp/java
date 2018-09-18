package array;

/**
 * Class Check.
 * Implements verifying for an array of boolean.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class Check {
    /**
     * Method checks an array.
     *
     * @param aData Array.
     * @return Result.
     */
    public final boolean mono(final boolean[] aData) {
        boolean result = true;

        for (int i = 0; i < aData.length; i++) {
            if (aData[0] != aData[i]) {
                result = false;
                break;
            }

        }

        return result;
    }
}
