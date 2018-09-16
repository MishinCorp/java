package counterforevennumbers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest.
 * Tests Counter class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class CounterTest {
    /**
     * Test add.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int expect = 30;
        int result = counter.add(1, 10);

        assertThat(result, is(expect));
    }
}
