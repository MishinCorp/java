package simplelambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class CalculatorTest.
 * Tests Calculator class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 02.10.2018
 */
public class CalculatorTest {
    /**
     * Tests method div with method reference.
     */
    @Test
    public void whenDiv1Until3MRef() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();

        calc.multiple(
                1, 3, 2,
                MathUtil::div,
                buffer::add
        );

        assertThat(buffer, is(Arrays.asList(2D, 1D)));
    }

    /**
     * Tests method multiple.
     */
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();

        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );

        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    /**
     * Tests method multiple with method reference.
     */
    @Test
    public void whenAdd1Until3MRef() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();

        calc.multiple(
                0, 3, 1,
                MathUtil::add,
                buffer::add
        );

        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}