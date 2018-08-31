package lambdaexamples;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SortArrayTest.
 * Tests SortArray class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class SortArrayTest {
    private final static String[] STRINGS = {"abc", "ab", "a"};
    private final static String[] EXPECTED = {"a", "ab", "abc"};

    /**
     * Method tests sortByComparator method.
     */
    @Test
    public void whenSortByComparator() {
        SortArray sortArray = new SortArray();

        String[] result = sortArray.sortByComparator(STRINGS);
        assertThat(result, is(EXPECTED));
    }

    /**
     * Method tests sortByComparator method.
     */
    @Test
    public void whenSortByLambda() {
        SortArray sortArray = new SortArray();

        String[] result = sortArray.sortByLambda(STRINGS);
        assertThat(result, is(EXPECTED));
    }

    /**
     * Method tests sortByComparatorMethods method.
     */
    @Test
    public void whenSortByComporatorMethods() {
        SortArray sortArray = new SortArray();

        String[] result = sortArray.sortByComparatorMethods(STRINGS);
        assertThat(result, is(EXPECTED));
    }
}