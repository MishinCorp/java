package arithmetic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FactorialLoopTest.
 * Tests FactorialLoop class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class FactorialLoopTest {
    /**
     * Method tests calculation of factorial.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        FactorialLoop factorial = new FactorialLoop();

        int expect = 120;
        int result = factorial.calc(5);

        assertThat(result, is(expect));
    }

    /**
     * Method tests calculation of factorial.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        FactorialLoop factorial = new FactorialLoop();

        int expect = 1;
        int result = factorial.calc(0);

        assertThat(result, is(expect));
    }
}
