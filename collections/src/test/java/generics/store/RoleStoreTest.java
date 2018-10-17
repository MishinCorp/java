package generics.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class RoleStoreTest.
 * Tests RoleStore class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.10.2018
 */
public class RoleStoreTest {
    Role role1 = new Role("1");
    Role role2 = new Role("2");
    Role role3 = new Role("3");

    /**
     * Tests add() and findById() methods.
     */
    @Test
    public void whenAddNewRoleThenGetId() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        String result = roleStore.findById("0").getId();
        String expected = "1";

        assertThat(result, is(expected));
    }

    /**
     * Test delete() method.
     */
    @Test
    public void whenDelete() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.delete("0");
        String result = roleStore.findById("0").getId();
        String expected = "2";

        assertThat(result, is(expected));
    }

    /**
     * Test replace() method.
     */
    @Test
    public void whenReplace() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.replace("0", role3);
        String result = roleStore.findById("0").getId();
        String expected = "3";

        assertThat(result, is(expected));
    }
}
