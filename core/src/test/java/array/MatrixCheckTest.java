package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MatrixCheckTest.
 * Tests MatrixCheck class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.09.2018
 */
public class MatrixCheckTest {
    /**
     * Tests mono method.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);

        assertThat(result, is(true));
    }

    /**
     * Tests mono method.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);

        assertThat(result, is(false));
    }

    /**
     * Tests mono method.
     */
    @Test
    public void whenDataMonoByTrueAndFalseThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true}
        };
        boolean result = check.mono(input);

        assertThat(result, is(true));
    }

    /**
     * Tests mono method.
     */
    @Test
    public void whenDataNotMonoByTrueOrFalseThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {true, true}
        };
        boolean result = check.mono(input);

        assertThat(result, is(false));
    }
}