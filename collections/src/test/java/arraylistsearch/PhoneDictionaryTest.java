package arraylistsearch;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class PhoneDictionaryTest.
 * Tests PhoneDictionary class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.09.2018
 */
public class PhoneDictionaryTest {
    public static final PhoneDictionary DICTIONARY = new PhoneDictionary();

    private static final Person PERSON = new Person(
            "Yura",
            "Mishin",
            "555",
            "Russia");

    /**
     * Init tests.
     *
     * @throws Exception Exception.
     */
    @Before
    public void init() throws Exception {
        DICTIONARY.add(PERSON);

    }

    /**
     * Tests find an entry by name.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenSearchByNameThenGetEntry() throws Exception {
        String expected = "Yura";
        String result = DICTIONARY.find("Yu").stream().map(Person::getName).findFirst().get();
        assertThat(result, is(expected));
    }

    /**
     * Tests cannot find an entry by name.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenSearchByWrongNameThenGetNoEntry() throws Exception {
        int expected = 0;
        List<Person> result = DICTIONARY.find("AA");

        assertThat(result.size(), is(expected));
    }

    /**
     * Tests find an entry by surname.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenSearchBySurnameThenGetEntry() throws Exception {
        String expected = "Mishin";
        String result = DICTIONARY.find("sh").stream().map(Person::getSurname).findFirst().get();
        assertThat(result, is(expected));
    }

    /**
     * Tests find an entry by phone.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenSearchByPhoneThenGetEntry() throws Exception {
        String expected = "555";
        String result = DICTIONARY.find("55").stream().map(Person::getPhone).findFirst().get();
        assertThat(result, is(expected));
    }

    /**
     * Tests find an entry by address.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenSearchByAddressThenGetEntry() throws Exception {
        String expected = "Russia";
        String result = DICTIONARY.find("ss").stream().map(Person::getAddress).findFirst().get();
        assertThat(result, is(expected));
    }
}
