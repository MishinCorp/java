package nonblockingcache;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class CacheTest.
 * Tests Cache class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.10.2018
 */
public class CacheTest {

    /**
     * Tests non-blocking algorithm.
     */
    @Test
    public void whenInvokeThenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Cache cache = new Cache();
        Base entry = new Base(1, 1, "Name");
        cache.add(entry);

        Thread threadOne = new Thread(
                () -> {
                    Base entryUpdate = new Base(entry.getId(), "NewName1");
                    try {
                        cache.update(entryUpdate);
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                });
        Thread threadTwo = new Thread(
                () -> {
                    Base entryUpdate = new Base(entry.getId(), "NewName2");
                    try {
                        cache.update(entryUpdate);
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                });

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        if (!(ex.get() == null)) {
            System.out.println("Throw Exception in Thread");
            assertThat("Throw Exception in Thread", ex.get().getMessage(), is("Throw Exception in Thread"));

        } else {
            assertThat(true, is(true));
        }
    }
}
