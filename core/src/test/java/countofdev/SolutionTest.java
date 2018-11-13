package countofdev;

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

        assertThat(solution.count(3), is(2));
        assertThat(solution.count(10), is(4));
    }
}