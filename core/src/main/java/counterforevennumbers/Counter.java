package counterforevennumbers;

/**
 * Class Counter.
 * Calculates sum of the even numbers in an definite array.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class Counter {
    /**
     * Method calculates sum.
     *
     * @param aStart  From.
     * @param aFinish To.
     * @return Sum.
     */
    public final int add(final int aStart, final int aFinish) {
        int sum = 0;

        for (int i = aStart; i <= aFinish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
