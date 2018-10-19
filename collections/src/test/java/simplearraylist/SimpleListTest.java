package simplearraylist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleListTest.
 * Tests SimpleList class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.10.2018
 */
public class SimpleListTest {
    /**
     * Tests add() and get() methods.
     */
    @Test
    public void whenAddElementThanGet() {
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertThat(simpleList.get(0), is(1));
        assertThat(simpleList.get(1), is(2));
        assertThat(simpleList.get(2), is(3));
    }

    /**
     * Tests iterator() method. NoSuchElementException throwing.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorShouldReturnAllElements() {
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        Iterator it = simpleList.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Tests iterator(). ConcurrentModificationException throwing.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnConcurrentModificationException() {
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.add(1);
        simpleList.add(2);
        Iterator it = simpleList.iterator();
        simpleList.add(3);
        it.next();
    }
}
