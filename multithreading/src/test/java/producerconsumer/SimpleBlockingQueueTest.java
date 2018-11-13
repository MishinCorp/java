package producerconsumer;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleBlockingQueueTest.
 * Implements entity SimpleBlockingQueueTest.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.11.2018
 */
public class SimpleBlockingQueueTest {
    /**
     * Tests that threads work properly.
     */
    @Test
    public void whenInvokeThenResultsBuffer() throws Exception {
        final SimpleBlockingQueue queue = new SimpleBlockingQueue();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();

        assertThat(consumer.getBuffer(), is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}
