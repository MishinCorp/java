package simplequeue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleQueueTest.
 * Tests SimpleQueue class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class SimpleQueueTest {
    /**
     * Tests push() and poll() methods.
     */
    @Test
    public void pushThenPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }

    /**
     * Tests poll() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        queue.poll();
    }
}
