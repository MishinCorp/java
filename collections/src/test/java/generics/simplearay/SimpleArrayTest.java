package generics.simplearay;

import generics.simplearray.SimpleArray;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleArrayTest.
 * Tests SimpleArray class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray = new SimpleArray<>(3);

    /**
     * Test add() and get() methods.
     */
    @Test
    public void whenAddElementThenGetIt() {
        simpleArray.add(1);
        simpleArray.add(2);
        Integer result = simpleArray.get(1);
        Integer expected = 2;

        assertThat(result, is(expected));
    }

    /**
     * Test set() method.
     */
    @Test
    public void whenSetElement() {
        simpleArray.set(0, 5);
        Integer result = simpleArray.get(0);
        Integer expected = 5;

        assertThat(result, is(expected));
    }

    /**
     * Tests method delete().
     */
    @Test
    public void whenDeleteElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.delete(0);
        Integer result = simpleArray.get(0);
        Integer expected = 2;

        assertThat(result, is(expected));
    }

    /**
     * Tests NoSuchElementException throwing.
     */
    @Test(expected = NoSuchElementException.class)
    public void invocationOfDeleteMethodShouldThrowNoSuchElementException() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.delete(5);
    }

    /**
     * Tests method iterator().
     */
    @Test
    public void shouldReturnAllElements() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));

    }

    /**
     * Tests NoSuchElementException throwing.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator it = simpleArray.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }
}