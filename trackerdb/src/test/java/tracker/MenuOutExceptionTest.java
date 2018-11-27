package tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class MenuOutExceptionTest.
 * Tests MenuOutException class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class MenuOutExceptionTest {
    /**
     * Tests exception.
     */
    @Test
    public void whenInvokeThenCreateException() {
        String expected = "Message";
        RuntimeException runtimeException = new MenuOutException(expected);
        String result = runtimeException.getMessage();

        assertThat(result, is(expected));
    }
}