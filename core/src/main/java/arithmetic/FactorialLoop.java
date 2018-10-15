package arithmetic;

/**
 * Class FactorialLoop.
 * Implements factorial calculation over loop.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class FactorialLoop {
    /**
     * Method calculates factorial.
     *
     * @param aN Number.
     * @return Factorial.
     */
    public final int calc(final int aN) {
        int result = 1;
        if (aN == 0) {
            result = 1;
        } else {
            for (int i = 1; i <= aN; i++) {
                result *= i;
            }
        }
        return result;
    }
}
