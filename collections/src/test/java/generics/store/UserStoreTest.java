package generics.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class UserStoreTest.
 * Tests UserStore class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class UserStoreTest {
    User user1 = new User("1");
    User user2 = new User("2");
    User user3 = new User("3");

    /**
     * Test add() and findById() methods.
     */
    @Test
    public void whenAddNewUserThenGetId() {
        UserStore userStore = new UserStore();
        userStore.add(user1);
        String result = userStore.findById("0").getId();
        String expected = "1";

        assertThat(result, is(expected));
    }

    /**
     * Test delete() method.
     */
    @Test
    public void whenDelete() {
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        userStore.delete("0");
        String result = userStore.findById("0").getId();
        String expected = "2";

        assertThat(result, is(expected));
    }

    /**
     * Test replace() method.
     */
    @Test
    public void whenReplace() {
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        userStore.replace("0", user3);
        String result = userStore.findById("0").getId();
        String expected = "3";

        assertThat(result, is(expected));
    }
}
