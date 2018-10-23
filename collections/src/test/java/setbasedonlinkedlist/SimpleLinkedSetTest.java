package setbasedonlinkedlist;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleLinkedSetTest.
 * Tests SimpleLinkedSet class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public class SimpleLinkedSetTest {
    /**
     * Tests add() method.
     */
    @Test
    public void whenAddElementThenIterator() {
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();
        set.add(100);
        set.add(2);
        set.add(25);
        set.add(25);
        set.add(26);
        Iterator<Integer> it = set.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(100));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(25));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(26));
        assertThat(it.hasNext(), is(false));
    }
}
