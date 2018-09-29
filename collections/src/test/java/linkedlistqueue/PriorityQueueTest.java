package linkedlistqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PriorityQueueTest.
 * Tests PriorityQueue class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.09.2018
 */
public class PriorityQueueTest {
    /**
     * Tests pollFirst method.
     */
    @Test
    public void whenInvokeThenGetHighPriorityTask() {
        PriorityQueue queue = new PriorityQueue();

        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));

        Task result = queue.pollFirst();
        String expected = "urgent";

        assertThat(result.getDesc(), is(expected));
    }

    /**
     * Tests pollLast method.
     */
    @Test
    public void whenInvokeThenGetLowestPriorityTask() {
        PriorityQueue queue = new PriorityQueue();

        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        queue.put(new Task("low", 3));
        queue.put(new Task("new", 4));

        Task result = queue.pollLast();
        String expected = "new";

        assertThat(result.getDesc(), is(expected));
    }
}
