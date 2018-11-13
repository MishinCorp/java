package producerconsumer;

import java.util.stream.IntStream;

/**
 * Class Producer.
 * Implements the producer entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.10.2018
 */
public class Producer extends Thread {
    /**
     * Queue.
     */
    private SimpleBlockingQueue queue = new SimpleBlockingQueue();

    /**
     * Constructor.
     *
     * @param pQueue Queue.
     */
    public Producer(final SimpleBlockingQueue pQueue) {
        this.queue = pQueue;
    }

    @Override
    public final void run() {
        final int[] numbers = {0, 5};
        IntStream.range(numbers[0], numbers[1]).forEach(
                queue::offer
        );
    }
}
