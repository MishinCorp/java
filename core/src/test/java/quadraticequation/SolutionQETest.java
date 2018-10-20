package quadraticequation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SolutionQETest.
 * Tests SolutionQE class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.10.2018
 */
public class SolutionQETest {
    /**
     * Tests solve() method.
     */
    @Test
    public void whenInvokeThenReturnsTwoX() {
        SolutionQE solutionQE = new SolutionQE();
        double[] xs = solutionQE.solve(1, -70, 600);

        assertThat(xs[0], is(60.0));
        assertThat(xs[1], is(10.0));
    }

    /**
     * Tests solve() method.
     */
    @Test
    public void whenInvokeThenReturnsOneX() {
        SolutionQE solutionQE = new SolutionQE();
        double[] xs = solutionQE.solve(3, -18, 27);
        assertThat(xs[0], is(3.0));
    }

    /**
     * Tests solve() method.
     */
    @Test
    public void whenInvokeThenReturnsNoX() {
        SolutionQE solutionQE = new SolutionQE();
        double[] xs = solutionQE.solve(1, 15, 100);
        assertThat(0, is(xs.length));
    }
}