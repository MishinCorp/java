package lambdaexamples;

/**
 * Interface ISortArray.
 * Declares methods for sort exmaple class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public interface ISortArray {
    /**
     * Method sorts strings using Comparator.
     *
     * @param anArray Array.
     * @return String[].
     */
    String[] sortByComparator(final String[] anArray);

    /**
     * Method sorts strings using lambda.
     *
     * @param anArray Array.
     * @return String[].
     */
    String[] sortByLambda(final String[] anArray);
    /**
     * Method sorts strings using Comporator methods.
     *
     * @param anArray Array.
     * @return String[].
     */
    String[] sortByComparatorMethods(final String[] anArray);
}
