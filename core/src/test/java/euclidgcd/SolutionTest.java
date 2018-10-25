package euclidgcd;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public class SolutionTest {
    /**
     * Tests loop() and recur() methods.
     */
    @Test
    public void when26And18ThenReturns2() {
        Solution solution = new Solution();
        assertThat(solution.loop(26, 18), is(2));
        assertThat(solution.recur(26, 18), is(2));
    }
}