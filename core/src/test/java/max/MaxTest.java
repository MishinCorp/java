package max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest.
 * Tests Max class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class MaxTest {
    /**
     * Method tests max method.
     * The second number is max.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Method tests max method between three numbers.
     * The first number is max.
     */
    @Test
    public void whenFirstMoreThanTheOtherTwo() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }
}
