package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CheckTest.
 * Tests Check class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class CheckTest {
    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Method tests mono method.
     */
    @Test
    public void whenEvenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Method tests mono method.
     */
    @Test
    public void whenOddDataMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Method tests mono method.
     */
    @Test
    public void whenAllDataFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}