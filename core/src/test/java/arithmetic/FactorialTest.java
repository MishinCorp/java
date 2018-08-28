package arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class FactorialTest.
 * Tests Factorial.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2018
 */
public class FactorialTest {
    //    Factorial factorial = mock(Factorial.class);
    Factorial factorial = new Factorial();

    /**
     * Method tests factorial obtaining.
     */
    @Test
    public void whenRunThenGetFactorial() {
        long number = 0;
        long expected = 1;

//        when(factorial.get(number)).thenReturn(expected);
        long result = factorial.get(number);

        assertEquals(expected, result);
        assertEquals(1, factorial.get(1));
        assertEquals(2, factorial.get(2));
        assertEquals(6, factorial.get(3));

//        verify(factorial).get(number);
    }
}