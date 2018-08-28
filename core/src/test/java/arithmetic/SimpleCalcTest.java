package arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class SimpleCalcTest.
 * Tests SimpleCalc class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2018
 */
public class SimpleCalcTest {
    /**
     * Method uses Assert.assertEquals,  Assert.assertTrue.
     *
     * @throws Exception Exception
     */
    @Test
    public void testEquals() throws Exception {
        SimpleCalc calc = new SimpleCalc();
        int result = calc.sum(1, 1);
        int expected = 2;

        assertEquals(expected, result);
        assertTrue(expected == result);
    }

    /**
     * Method uses Assert.assertFalse.
     *
     * @throws Exception Exception
     */
    @Test
    public void testNotEquals() throws Exception {
        SimpleCalc calc = new SimpleCalc();
        int result = calc.sum(1, 1);
        int notExpected = 3;

        assertFalse(notExpected == result);
    }

    /**
     * Method throws Exception.
     */
    @Test(expected = RuntimeException.class)
    public void whenRunThenThrowException() {
        SimpleCalc calc = new SimpleCalc();
        int expected = 0;
        int result = calc.sum(0, 0);
        assertEquals(0, 0);
    }
}