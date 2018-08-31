package calculator;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//todo
public class NumberTest {
    //todo
    @Test
    public void whenThen() {
        INumber number = new Number(1);
        assertNotNull(number);
    }

    //todo
    @Test
    public void setValue() {
        INumber testNumber = new Number(1);
        testNumber.setValue(2);

        String expected = "2";
        String result = testNumber.toStr();

        assertThat(result, is(expected));
    }

    //todo
    @Test
    public void toStr() {
        INumber number = new Number(1);
        String expected = "1";
        String result = number.toStr();

        assertThat(result, is(expected));
    }
}