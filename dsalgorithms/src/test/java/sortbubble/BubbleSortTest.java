package sortbubble;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSortTest.
 * Tests BubbleSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class BubbleSortTest {
    /**
     * Tests sorting.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();

        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] result = bubbleSort.sort(input);

        assertThat(result, is(expected));
    }
}
