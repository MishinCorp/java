package statistics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class InfoTest.
 * Tests Info class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class InfoTest {
    /**
     * Tests info getters.
     */
    @Test
    public void whenInvokeThenGetInfoCounts() {
        Info info = new Info(1, 2, 3);
        assertThat(info.getAddCount(), is(1));
        assertThat(info.getRenameCount(), is(2));
        assertThat(info.getRemoveCount(), is(3));
    }
}