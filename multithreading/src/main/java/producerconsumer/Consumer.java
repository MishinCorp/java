package producerconsumer;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class Consumer.
 * Implements the consumer entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.10.2018
 */
public class Consumer extends Thread {
    /**
     * Queue.
     */
    private SimpleBlockingQueue queue = new SimpleBlockingQueue();
    /**
     * Buffer.
     */
    private final CopyOnWriteArrayList<Integer> buffer
            = new CopyOnWriteArrayList<>();

    /**
     * Constructor.
     *
     * @param pQueue Queue.
     */
    public Consumer(final SimpleBlockingQueue pQueue) {
        this.queue = pQueue;
    }

    /**
     * Buffer getter.
     *
     * @return Buffer.
     */
    public final CopyOnWriteArrayList<Integer> getBuffer() {
        return this.buffer;
    }

    @Override
    public final void run() {
        while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
            try {
                buffer.add((int) queue.poll());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
