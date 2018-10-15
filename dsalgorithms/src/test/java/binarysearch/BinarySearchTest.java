package binarysearch;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class BinarySearchTest.
 * Tests BinarySearch class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.10.2018
 */
public class BinarySearchTest {
    /**
     * Tests search() method.
     */
    @Test
    public void whenFindValueThenTrue() {
        int[] array = {1, 2, 3, 4, 5};
        int value = 3;
        boolean expected = true;
        boolean result = new BinarySearch().search(array, value);

        assertThat(result, is(expected));
    }

    /**
     * Tests search() method.
     */
    @Test
    public void whenValueOutOfRangeThenFalse() {
        int[] array = {1, 2, 3, 4, 5};
        int value = 30;
        boolean expected = false;
        boolean result = new BinarySearch().search(array, value);

        assertThat(result, is(expected));
    }
}