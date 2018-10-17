package singlylinkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSortTest.
 * Tests BubbleSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Method tests get() method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultsTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Method tests get() method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultsThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Method tests delete() method.
     */
    @Test
    public void whenDeleteThenSizeResultsTwo() {
        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>();
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        assertThat(simpleArrayList.delete(), is(3));
        assertThat(simpleArrayList.getSize(), is(2));
    }
}