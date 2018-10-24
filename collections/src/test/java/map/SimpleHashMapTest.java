package map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleHashMapTest.
 * Tests SimpleHashMap class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public class SimpleHashMapTest {
    /**
     * Tests insert() method.
     */
    @Test
    public void whenInsertThenReturnResult() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();

        assertThat(map.insert(1, "A"), is(true));
        assertThat(map.insert(2, "A"), is(true));
        assertThat(map.insert(1, "A"), is(false));
    }

    /**
     * Tests get() method.
     */
    @Test
    public void whenGetThenReturnValue() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "A");
        map.insert(2, "B");
        map.insert(3, "C");

        assertThat(map.get(1), is("A"));
        assertThat(map.get(2), is("B"));
        assertThat(map.get(3), is("C"));
    }

    /**
     * Tests get() method. Throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "A");
        map.insert(2, "B");

        assertThat(map.get(3), is("A"));
    }

    /**
     * Tests delete() method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteThenReturnResult() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "A");
        map.insert(2, "B");
        map.insert(3, "С");

        assertThat(map.delete(1), is(true));
        assertThat(map.delete(1), is(false));
        assertThat(map.get(1), is("A"));
    }

    /**
     * Tests iterator() method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIterator() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();

        map.insert(1, "A");
        map.insert(37, "B");
        map.insert(54, "С");

        Iterator it = map.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(37));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(54));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
