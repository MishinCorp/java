package minmaxpair;

/**
 * Interface IMinMax.
 * Declares methods for getting min-max as a pair.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public interface IMinMax {
    /**
     * Method gets min() and max() as a pair.
     *
     * @param anArray Array.
     * @return Pair(min, max).
     */
    MinMaxPair.Pair getMinMax(final int[] anArray);
}
