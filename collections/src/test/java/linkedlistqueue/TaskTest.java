package linkedlistqueue;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class TaskTest.
 * Tests Task class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.09.2018
 */
public class TaskTest {
    public static final Task TASK = new Task("Task", 1);

    /**
     * Tests getDesc method.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetDescription() throws Exception {
        String expected = "Task";
        String result = TASK.getDesc();
        assertThat(result, is(expected));
    }

    /**
     * Tests getPriority method.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetPriority() throws Exception {
        int expected = 1;
        int result = TASK.getPriority();
        assertThat(result, is(expected));
    }
}