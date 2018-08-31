package lambdaexamples;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class SortArray.
 * Implements ISortArray.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class SortArray implements ISortArray {
    /**
     * Method sorts strings using Comparator.
     *
     * @param anArray Array.
     * @return String[].
     */
    @Override
    public final String[] sortByComparator(final String[] anArray) {
        Comparator<String> sortByLength = new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                return o1.length() - o2.length();
            }
        };

        Arrays.sort(anArray, sortByLength);

        return anArray;
    }

    /**
     * Method sorts strings using lambda.
     *
     * @param anArray Array.
     * @return String[].
     */
    @Override
    public final String[] sortByLambda(final String[] anArray) {

        Arrays.sort(anArray, (first, second) ->
                first.length() - second.length());

        return anArray;
    }

    /**
     * Method sorts strings using Comporator methods.
     *
     * @param anArray Array.
     * @return String[].
     */
    @Override
    public final String[] sortByComparatorMethods(final String[] anArray) {

        Arrays.sort(anArray, Comparator.comparing(String::length));

        return anArray;
    }
}
