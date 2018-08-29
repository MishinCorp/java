package arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

/**
 * Class FibonacciTest.
 * Tests class Fibonacci.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.08.2018
 */
public class FibonacciTest {
//    Fibonacci fib = mock(Fibonacci.class);
    Fibonacci fib = new Fibonacci();

    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithZeroOrLessThenGetZero() {
        long n = 0;
        long expected = 0;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithOneThenGetOne() {
        long n = 1;
        long expected = 1;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithTwoThenGetOne() {
        long n = 2;
        long expected = 1;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithThreeGetTwo() {
        long n = 3;
        long expected = 2;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithFourThenGetThree() {
        long n = 4;
        long expected = 3;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
    /**
     * Method test obtaining fibonacci number.
     */
    @Test
    public void whenInvokeWithSevenThenGetThirteen() {
        long n = 7;
        long expected = 13;

//        when(fib.getNumber(n)).thenReturn(expected);
        long result = fib.getNumber(n);

        assertEquals(expected, result);

//        verify(fib).getNumber(n);
    }
}