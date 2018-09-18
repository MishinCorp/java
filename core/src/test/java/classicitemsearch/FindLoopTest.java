package classicitemsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FindLoopTest.
 * Tests FindLoop class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class FindLoopTest {
    /**
     * Tests that item is found.
     */
    @Test
    public void whenFindItemThanReturnIndex() {
        FindLoop findLoop = new FindLoop();

        int[] input = {1, 2, 3, 4, 5};
        int expected = 2;
        int result = findLoop.indexOf(input, 3);

        assertThat(result, is(expected));
    }

    /**
     * Tests that item is not found.
     */
    @Test
    public void whenDoNotFindItemThanReturnFlag() {
        FindLoop findLoop = new FindLoop();

        int[] input = {1, 2, 3, 4, 5};
        int expected = -1;
        int result = findLoop.indexOf(input, 10);

        assertThat(result, is(expected));
    }
}
