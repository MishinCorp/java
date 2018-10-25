package dectobin;

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
     * Tests methods which gets binary.
     */
    @Test
    public void when10ThenReturns1010() {
        Solution solution = new Solution();
        int pN = 10;
        String expected = "1010";

        assertThat(solution.toBinaryStd(pN), is(expected));
        assertThat(solution.toBinRadix(pN), is(expected));
        assertThat(solution.toBinCustom(pN), is(expected));
    }
}