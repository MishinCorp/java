package setbasedonhashtable;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleHashSetTest.
 * Tests SimpleHashSet class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 23.10.2018
 */
public class SimpleHashSetTest {
    /**
     * Tests add() method. We could add an element.
     */
    @Test
    public void whenAddThenReturnTrue() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();

        assertThat(set.add(0), is(true));
        assertThat(set.add(2), is(true));
        assertThat(set.add(4), is(true));
    }

    /**
     * Tests add() method. We could not add an element.
     */
    @Test
    public void whenCanNotAddThenReturnFalse() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();

        assertThat(set.add(100), is(false));
        assertThat(set.add(200), is(false));
        assertThat(set.add(400), is(false));
    }

    /**
     * Tests contains() method.
     */
    @Test
    public void whenContainsThenReturnTrue() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.contains(1), is(true));
        assertThat(set.contains(3), is(true));
    }

    /**
     * Tests contains() method.
     */
    @Test
    public void whenDoesNotContainThenReturnFalse() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.contains(4), is(false));
        assertThat(set.contains(30), is(false));
    }

    /**
     * Tests remove() method.
     */
    @Test
    public void whenRemoveThenReturnTrue() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.remove(2), is(true));
    }

    /**
     * Tests remove() method.
     */
    @Test
    public void whenCanNotRemoveThenReturnFalse() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.remove(4), is(false));
    }
}
