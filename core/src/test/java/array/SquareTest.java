package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SquareTest.
 * Tests Square class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class SquareTest {
    /**
     * Tests that the array consists of squares from 1 to 3.
     */
    @Test
    public void whenInputThreeThanResultArrayOfSquaresTillThree() {
        Square squares = new Square();

        int[] expected = {1, 4, 9};
        int[] result = squares.calculate(3);

        assertThat(result, is(expected));
    }
}
