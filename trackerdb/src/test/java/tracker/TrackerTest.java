package tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest.
 * Tests Tracker class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class TrackerTest {
    private final Tracker tracker = new Tracker();

    private final Item item1 = new Item("test1", "testDescription1", 123L);
    private final Item item2 = new Item("test2", "testDescription2", 123L);
    private final Item item3 = new Item("test3", "testDescription3", 123L);
    private final Item item4 = new Item("test1", "testDescription4", 123L);

    @Before
    public void init() {
        this.tracker.add(item1);
        this.tracker.add(item2);
        this.tracker.add(item3);
        this.tracker.add(item4);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddNewItem() {
        Item item5 = new Item("test5", "testDescription5", 123L);
        this.tracker.add(item5);

        Item result = this.tracker.findAll().get(4);

        assertThat(result, is(item5));
    }

    /**
     * Tests find by id method.
     */
    @Test
    public void whenSearchByIdThenReturnItem() {

        String expected = "test1";
        String result = tracker.findById(this.item1.getId()).getName();

        assertThat(result, is(expected));
    }

    /**
     * Tests find by name method.
     */
    @Test
    public void whenSearchByNameThenReturnItems() {
        String expected = "test1 test1";

        ArrayList<Item> resultArray = this.tracker.findByName("test1");
        String result = resultArray.get(0).getName() + " " + resultArray.get(1).getName();

        assertThat(result, is(expected));
    }

    /**
     * Tests edit method.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item item6 = new Item("test6", "testDescription6", 123L);
        item6.setId(this.item1.getId());
        tracker.replace(this.item1.getId(), item6);

        String expected = "test6";
        String result = tracker.findById(this.item1.getId()).getName();

        assertThat(result, is(expected));
    }

    /**
     * Tests remove method.
     */
    @Test
    public void whenDeleteItem() {
        this.tracker.delete(item2.getId());

        int expected = 3;
        int result = this.tracker.findAll().size();

        assertThat(result, is(expected));
    }
}
