package sortselection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SelectionSortTest.
 * Tests SelectionSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.10.2018
 */
public class SelectionSortTest {
    /**
     * Tests quickSort() method.
     */
    @Test
    public void whenInvokeThenSort() {
        int[] array = {3, 8, 2, 5, 0, 1, 4, 10};
        int[] result = {0, 1, 2, 3, 4, 5, 8, 10};
        new SelectionSort().sort(array);

        assertThat(result, is(array));
    }
}