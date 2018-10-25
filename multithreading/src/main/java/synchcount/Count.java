package synchcount;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count.
 * Implements simple count.
 * Threadsafe.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
@ThreadSafe
public class Count {
    /**
     * Value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Method increments the count.
     */
    public final void increment() {
        synchronized (this) {
            this.value++;
        }
    }

    /**
     * Method get the value.
     *
     * @return Value.
     */
    public final synchronized int get() {
        return this.value;
    }
}
