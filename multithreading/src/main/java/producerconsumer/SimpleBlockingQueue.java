package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class SimpleBlockingQueue.
 * Implements BlockingQueue.
 *
 * @param <T> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.10.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * Storage.
     */
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    /**
     * Method adds a value.
     *
     * @param pValue Value.
     */
    public final synchronized void offer(final T pValue) {
        while (!this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.offer(pValue);
        notify();
    }

    /**
     * Method retrieves a value.
     *
     * @return value Value.
     * @throws InterruptedException InterruptedException.
     */
    public final synchronized T poll() throws InterruptedException {
        T result;
        while (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        result = this.queue.poll();
        notify();

        return result;
    }

    /**
     * Method checks if the queue is empty.
     *
     * @return boolean.
     */
    public final synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
