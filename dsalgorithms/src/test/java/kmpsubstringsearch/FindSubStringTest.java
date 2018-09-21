package kmpsubstringsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FindSubStringTest.
 * Tests FindSubString class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 21.09.2018
 */
public class FindSubStringTest {
    /**
     * Tests that the string contains the substring.
     */
    @Test
    public void whenFindSubstringThenResultTrue() {
        FindSubString findSubString = new FindSubString();

        String origin = "Привет";
        String sub = "иве";
        boolean result = findSubString.contains(origin, sub);

        assertThat(result, is(true));
    }

    /**
     * Tests that the string does not contain the substring.
     */
    @Test
    public void whenDoNotFindSubstringThenResultFalse() {
        FindSubString findSubString = new FindSubString();

        String origin = "Привет";
        String sub = "Абв";
        boolean result = findSubString.contains(origin, sub);

        assertThat(result, is(false));
    }
}