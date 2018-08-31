package calculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Class NumberTest.
 * Tests Number.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class NumberTest {
    /**
     * Method test instance.
     */
    @Test
    public void whenCreateObj() {
        INumber number = new Number(1);
        assertNotNull(number);
    }

    /**
     * Method tests set value.
     */
    @Test
    public void whenSetValue() {
        INumber testNumber = new Number(1);
        testNumber.setValue(2);

        String expected = "2";
        String result = testNumber.toString();

        assertThat(result, is(expected));
    }

    /**
     * Method tests toString.
     */
    @Test
    public void whenToString() {
        INumber number = new Number(1);
        String expected = "1";
        String result = number.toString();

        assertThat(result, is(expected));
    }

    /**
     * Method tests addition.
     */
    @Test
    public void whenAdd() {
        INumber argOne = new Number(1);
        INumber argTwo = new Number(1);
        String expected = "2";
        String result = argOne.add(argTwo).toString();

        assertThat(result, is(expected));
    }
}