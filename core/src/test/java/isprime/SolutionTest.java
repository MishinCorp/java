package isprime;

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
     * Tests isPrime() method.
     */
    @Test
    public void whenInvokeThenCheckResult() {
        Solution solution = new Solution();

        assertThat(solution.isPrime(3), is(true));
        assertThat(solution.isPrime(10), is(false));
    }
}