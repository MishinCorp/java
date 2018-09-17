package triangle;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class PointTest.
 * Tests Point class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class PointTest {
    /**
     * Method tests distance calculation.
     */
    @Test
    public void whenInvokeThenGetDistance() {
        Point pointA = new Point(3, -4);
        double result = pointA.distanceTo(new Point(-6, 5));

        assertThat(result, closeTo(12.73, 0.1));
    }
}