package array;

/**
 * Class MatrixCheck.
 * Implements verifying for two dimensional array of boolean.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.09.2018
 */
public class MatrixCheck {
    /**
     * Method checks diagonals.
     *
     * @param aData Array.
     * @return result Boolean.
     */
    public final boolean mono(final boolean[][] aData) {
        boolean result = true;

        for (int i = 0; i < aData.length; i++) {
            if (aData[i][i] != aData[0][0]) {
                result = false;
                break;
            }

            if (aData[i][aData.length - i - 1] != aData[0][aData.length - 1]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
