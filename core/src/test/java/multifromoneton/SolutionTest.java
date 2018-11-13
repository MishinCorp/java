package multifromoneton;

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
     * Tests multi() method.
     */
    @Test
    public void whenInvokeThenMulti() {
        Solution solution = new Solution();

        assertThat(solution.multi(2), is(2));
        assertThat(solution.multi(5), is(120));
    }
}