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
}