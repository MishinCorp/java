package arithmetic;

/**
 * Class Fibonacci.
 * Calculates fibonacci.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.08.2018
 */
public final class Fibonacci {
    /**
     * Method calculates fibo number.
     *
     * @param aNumber Number.
     * @return Fibo number.
     */
    public long getNumber(final long aNumber) {
        long result;

        if (aNumber <= 0) {
            result = 0;
        } else if (aNumber == 1) {
            result = 1;
        } else if (aNumber == 2) {
            result = 1;
        } else {
            result = getNumber(aNumber - 2) + getNumber(aNumber - 1);
        }

        return result;
    }
}
