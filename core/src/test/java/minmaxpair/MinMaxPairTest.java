package minmaxpair;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class MinMaxPairTest.
 * Tests MinMaxPair class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class MinMaxPairTest {
    /**
     * Method tests getting the min of the array.
     */
    @Test
    public void whenInvokeThenGetMin() {
        int[] array = {1, -2, 3, 4, 5};

        int expectedMin = -2;
        int resultMin = new MinMaxPair().getMinMax(array).getMin();

        assertThat(resultMin, is(expectedMin));
    }

    /**
     * Method tests getting the max of the array.
     */
    @Test
    public void whenInvokeThenGetmax() {
        int[] array = {1, -2, 3, 4, 5};

        int expectedMax = 5;
        int resultMax = new MinMaxPair().getMinMax(array).getMax();

        assertThat(resultMax, is(expectedMax));
    }
}