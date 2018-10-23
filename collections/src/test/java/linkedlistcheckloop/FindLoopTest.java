package linkedlistcheckloop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class FindLoopTest.
 * Tests FindLoop class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class FindLoopTest {
    /**
     * Tests hasCycle() method. Find loop.
     */
    @Test
    public void whenFindLoopThenResultTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        assertThat(new FindLoop().hasCycle(first), is(true));
    }

    /**
     * Tests hasCycle() method. No loop.
     */
    @Test
    public void whenNoLoopThenResultFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);

        assertThat(new FindLoop().hasCycle(first), is(false));
    }

    /**
     * Tests hasCycle() method. Loop in the center.
     */
    @Test
    public void whenLoopThenResultTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(two);
        four.setNext(null);

        assertThat(new FindLoop().hasCycle(first), is(true));
    }
}
