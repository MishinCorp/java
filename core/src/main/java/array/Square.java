package array;

/**
 * Class Square.
 * Fills the array with square of a number.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class Square {
    /**
     * Methods calculates square.
     *
     * @param aBound Up to this number.
     * @return Array.
     */
    public final int[] calculate(final int aBound) {
        int[] rst = new int[aBound];

        for (int i = 0; i < aBound; i++) {
            rst[i] = (int) Math.pow((i + 1), 2);
        }

        return rst;
    }
}
