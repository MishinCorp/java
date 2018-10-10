package treeset;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 * Tests SortUser class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.10.2018
 */
public class SortUserTest {
    /**
     * Test method sort.
     */
    @Test
    public void whenAddListThenResultSortedSet() {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(Arrays.asList(
                new User("Petr", 18),
                new User("Ivan", 5),
                new User("Ivan", 5),
                new User("John", 8),
                new User("Mike", 80)
        ));

        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(usersList);

        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("Ivan", 5),
                new User("John", 8),
                new User("Petr", 18),
                new User("Mike", 80)
        ));

        assertThat(result, is(expected));
    }

    /**
     * Tests method sortNameLength.
     */
    @Test
    public void whenAddListThenResultSortByNameLength() {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(Arrays.asList(
                new User("Petr", 18),
                new User("Iva", 5),
                new User("Petr", 18),
                new User("Johnn", 8),
                new User("Mikess", 80)
        ));

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(usersList);

        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                new User("Iva", 5),
                new User("Petr", 18),
                new User("Petr", 18),
                new User("Johnn", 8),
                new User("Mikess", 80)
        ));

        assertThat(result, is(expected));
    }

    /**
     * Tests method sortByAllFields.
     */
    @Test
    public void whenAddListThanResultSortByAllFields() {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(Arrays.asList(
                new User("Ivan", 18),
                new User("Sergey", 5),
                new User("Ivan", 8),
                new User("Sergey", 80)
        ));

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(usersList);

        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                new User("Ivan", 8),
                new User("Ivan", 18),
                new User("Sergey", 5),
                new User("Sergey", 80)
        ));

        assertThat(result, is(expected));
    }
}
