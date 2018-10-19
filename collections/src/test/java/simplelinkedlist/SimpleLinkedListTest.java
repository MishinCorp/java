package simplelinkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleLinkedListTest.
 * Tests SimpleLinkedList class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 19.10.2018
 */

public class SimpleLinkedListTest {
    /**
     * Tests add() and get() methods.
     */
    @Test
    public void whenGetElementThanGetIt() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
    }

    /**
     * Tests add() and get()methods. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        list.get(3);
    }

    /**
     * Tests iterator() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorShouldReturnAllElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator it = list.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Tests iterator() method. Throws ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowConcurrentModificationException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        list.add(4);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
    }

    /**
     * Tests removeHead() method.
     */
    @Test
    public void whenRemoveHeadThenGetHead() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.removeHead(), is(1));
        assertThat(list.removeHead(), is(2));
        assertThat(list.removeHead(), is(3));
    }

    /**
     * Tests removeHead() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void forRemoveHeadShouldThrowNoSuchElementException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.removeHead(), is(1));
        assertThat(list.removeHead(), is(2));
        assertThat(list.removeHead(), is(3));
        assertThat(list.removeHead(), is(4));
    }

    /**
     * Tests removeTail() method.
     */
    @Test
    public void whenRemoveTailThanGetTail() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.removeTail(), is(3));
        assertThat(list.removeTail(), is(2));
        assertThat(list.removeTail(), is(1));
    }

    /**
     * Tests removeTail() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void forRemoveTailShouldThrowNoSuchElementException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.removeTail(), is(3));
        assertThat(list.removeTail(), is(2));
        assertThat(list.removeTail(), is(1));
        assertThat(list.removeTail(), is(0));
    }
}
