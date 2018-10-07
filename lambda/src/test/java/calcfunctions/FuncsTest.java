package calcfunctions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class FuncsTest.
 * Tests Funcs class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 03.10.2018
 */
public class FuncsTest {
    /**
     * Test linear function.
     * f(x) = a + bx.
     */
    @Test
    public void whenInvokeThenReturnsLinearValues() {
        Funcs funcs = new Funcs();

        List<Double> expected = Arrays.asList(1D, 2D, 3D);
        List<Double> result = funcs.range(0, 2,
                (pStart) -> 1 * pStart + 1);

        assertThat(result, is(expected));
    }

    /**
     * Test quadratic function.
     * f(x) = ax2 + bx + c.
     */
    @Test
    public void whenInvokeThenReturnsQuadraticValues() {
        Funcs funcs = new Funcs();

        List<Double> expected = Arrays.asList(1D, 3D, 7D);
        List<Double> result = funcs.range(0, 2,
                (pStart) -> 1 * Math.pow(pStart, 2) + 1 * pStart + 1);

        assertThat(result, is(expected));
    }

    /**
     * Test logarithm Function.
     * f(x) = ln(x).
     */
    @Test
    public void whenInvokeThenReturnsLogarithmValues() {
        Funcs funcs = new Funcs();

        List<Double> expected = Arrays.asList(0D, 0.301D, 0.477D);
        List<Double> result = funcs.range(1, 3,
                (pStart) -> {
                    double resultValue = Math.log10(pStart);
                    resultValue = Math.rint(resultValue * 1000) / 1000;
                    return resultValue;
                });

        assertThat(result, is(expected));
    }
}