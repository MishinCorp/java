package simplestack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleStackTest.
 * Tests SimpleStack class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class SimpleStackTest {
    /**
     * Tests push() and poll() methods.
     */
    @Test
    public void pushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    /**
     * Tests poll() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        stack.poll();
    }
}
