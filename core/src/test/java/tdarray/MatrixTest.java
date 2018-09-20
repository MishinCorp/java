package tdarray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MatrixTest.
 * Tests Matrix class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.09.2018
 */
public class MatrixTest {
    /**
     * Tests checks the 2x2 matrix building.
     */
    @Test
    public void whenSizeTwoThenGet4Results() {

        Matrix matrix = new Matrix();

        int[][] expected = {{1, 2}, {2, 4}};
        int[][] result = matrix.multiple(2);

        assertThat(result, is(expected));
    }

    /**
     * Tests checks the 3x3 matrix building.
     */
    @Test
    public void whenSizeThreeThenGet9Results() {

        Matrix matrix = new Matrix();

        int[][] expected = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        int[][] result = matrix.multiple(3);

        assertThat(result, is(expected));
    }

    /**
     * Tests checks the 5x5 matrix building.
     */
    @Test
    public void whenSizeFiveThenGet25Results() {

        Matrix matrix = new Matrix();

        int[][] expected = {{1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15},
                {4, 8, 12, 16, 20},
                {5, 10, 15, 20, 25}};

        int[][] result = matrix.multiple(5);

        assertThat(result, is(expected));
    }
}
