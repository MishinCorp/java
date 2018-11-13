package sumfromoneton;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.10.2018
 */
public class SolutionTest {

    /**
     * Tests sum() method.
     */
    @Test
    public void whenInvokeThenSum() {
        Solution solution = new Solution();

        assertThat(solution.sum(3), is(6));
        assertThat(solution.sum(10), is(55));
    }
}