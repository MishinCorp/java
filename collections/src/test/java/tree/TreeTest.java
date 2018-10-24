package tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class TreeTest.
 * Tests class TreeTest.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public class TreeTest {
    /**
     * Tests add() method.
     */
    @Test
    public void whenNodeFindThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Tests add() method.
     */
    @Test
    public void whenNodeDoesNotExistThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);

        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Tests add() method.
     */
    @Test
    public void whenNodeAlreadyExistsThenFalse() {
        Tree<Integer> tree = new Tree<>(1);

        tree.add(1, 2);
        tree.add(1, 3);

        assertThat(tree.add(1, 2), is(false)
        );
    }

    /**
     * Tests iterator() method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));

        it.next();
    }

    /**
     * Tests isBinary() method.
     */
    @Test
    public void whenBinaryThenReturnTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);

        assertThat(tree.isBinary(), is(true));
    }

    /**
     * Tests isBinary() method.
     */
    @Test
    public void whenNotBinaryThenReturnFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(tree.isBinary(), is(false));
    }
}
