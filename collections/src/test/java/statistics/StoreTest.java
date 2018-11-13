package statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class StoreTest.
 * Tests Store class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class StoreTest {
    /**
     * Tests diff() method.
     * Results with no changes.
     */
    @Test
    public void whenInvokeThenResultsNoChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1"),
                new Store.User(3, "User3")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(3, "User3"),
                new Store.User(2, "User2"),
                new Store.User(1, "User1")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getRenameCount(), is(0));
        assertThat(info.getRemoveCount(), is(0));
    }

    /**
     * Tests diff() method.
     * Add one item.
     */
    @Test
    public void whenAddOneItemThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(3, "User3"),
                new Store.User(2, "User2"),
                new Store.User(1, "User1")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(1));
        assertThat(info.getRenameCount(), is(0));
        assertThat(info.getRemoveCount(), is(0));
    }

    /**
     * Tests diff() method.
     * Add two items.
     */
    @Test
    public void whenAddTwoItemsThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(2, "User2"),
                new Store.User(4, "User4"),
                new Store.User(1, "User1"),
                new Store.User(3, "User3")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(2));
        assertThat(info.getRenameCount(), is(0));
        assertThat(info.getRemoveCount(), is(0));
    }

    /**
     * Tests diff() method.
     * Rename one item.
     */
    @Test
    public void whenRenameOneItemThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(2, "User2"),
                new Store.User(1, "RENAME")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getRenameCount(), is(1));
        assertThat(info.getRemoveCount(), is(0));
    }

    /**
     * Tests diff() method.
     * Rename two items.
     */
    @Test
    public void whenRenameTwoItemsThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1"),
                new Store.User(3, "User3")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(3, "ReName"),
                new Store.User(2, "User2"),
                new Store.User(1, "RENAME")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getRenameCount(), is(2));
        assertThat(info.getRemoveCount(), is(0));
    }

    /**
     * Tests diff() method.
     * Remove one item.
     */
    @Test
    public void whenRemoveOneItemThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1"),
                new Store.User(3, "User3")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(3, "User3"),
                new Store.User(1, "User1")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getRenameCount(), is(0));
        assertThat(info.getRemoveCount(), is(1));
    }

    /**
     * Tests diff() method.
     * Remove all items.
     */
    @Test
    public void whenRemoveAllItemsThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(2, "User2"),
                new Store.User(1, "User1"),
                new Store.User(3, "User3")
        );
        Store store = new Store();
        Info info = store.diff(previous, new ArrayList<>());
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getRenameCount(), is(0));
        assertThat(info.getRemoveCount(), is(3));
    }

    /**
     * Tests diff() method.
     * Add, rename and remove mix.
     */
    @Test
    public void whenAddRenameRemoveThenResultsWithChanges() {
        List<Store.User> previous = new ArrayList<>();
        Collections.addAll(
                previous,
                new Store.User(1, "User1"),
                new Store.User(2, "User2")
        );
        List<Store.User> current = new ArrayList<>();
        Collections.addAll(
                current,
                new Store.User(4, "User4"),
                new Store.User(3, "User3"),
                new Store.User(1, "RENAME")
        );
        Store store = new Store();
        Info info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(2));
        assertThat(info.getRenameCount(), is(1));
        assertThat(info.getRemoveCount(), is(1));
    }
}