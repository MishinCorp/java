package arithmetic;

/**
 * Class Factorial.
 * Calculates factorial.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2018
 */
public class Factorial {
    /**
     * Method calculates factorial.
     *
     * @param aNumber Number.
     * @return Factorial.
     */
    public final long get(final long aNumber) {
        if (aNumber == 0) {
            return 1;
        } else if (aNumber == 1) {
            return 1;
        } else if (aNumber == 2) {
            return 2;
        } else {
            return get(aNumber - 1) * aNumber;
        }
    }
}
