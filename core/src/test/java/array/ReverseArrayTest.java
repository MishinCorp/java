package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ReverseArrayTest.
 * Tests ReverseArray class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class ReverseArrayTest {
    /**
     * Tests reversing.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        ReverseArray turn = new ReverseArray();

        int[] input = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};
        int[] result = turn.back(input);

        assertThat(result, is(expected));
    }

    /**
     * Tests reversing..
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        ReverseArray turn = new ReverseArray();

        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = turn.back(input);

        assertThat(result, is(expected));
    }
}

