package arraylistsearch;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class PersonTest.
 * Tests Person class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.09.2018
 */
public class PersonTest {
    private static final Person PERSON = new Person(
            "Yura",
            "Mishin",
            "555",
            "Russia");

    /**
     * Tests getName method.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetName() throws Exception {
        String expected = "Yura";
        String result = PERSON.getName();
        assertThat(result, is(expected));
    }

    /**
     * Tests getSurname method.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetSurname() throws Exception {
        String expected = "Mishin";
        String result = PERSON.getSurname();
        assertThat(result, is(expected));
    }

    /**
     * Tests getPhone method.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetPhone() throws Exception {
        String expected = "555";
        String result = PERSON.getPhone();
        assertThat(result, is(expected));
    }

    /**
     * Tests getAddress method.
     *
     * @throws Exception Exception.
     */

    @Test
    public void whenInvokeThenGetAddress() throws Exception {
        String expected = "Russia";
        String result = PERSON.getAddress();
        assertThat(result, is(expected));
    }
}