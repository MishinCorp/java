package userstorage;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class UserStorageTest.
 * Tests UserStorage class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public class UserStorageTest {
    /**
     * Tests add() method.
     */
    @Test
    public void whenAdd() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);

        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user1), is(false));
    }

    /**
     * Tests update() method.
     */
    @Test
    public void whenUpdate() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        storage.add(user1);

        assertThat(storage.update(user1, 10), is(true));
        assertThat(storage.update(user2, 10), is(false));
    }

    /**
     * Tests delete() method.
     */
    @Test
    public void whenDelete() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        storage.add(user1);
        storage.add(user2);

        assertThat(storage.delete(user1), is(true));
    }

    /**
     * Tests transfer() method.
     */
    @Test
    public void whenTransfer() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);

        storage.add(user1);
        storage.add(user2);

        assertThat(storage.transfer(1, 2, 10), is(true));
    }
}
