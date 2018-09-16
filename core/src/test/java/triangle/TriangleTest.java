package triangle;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class TriangleTest.
 * Tests Triangle class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class TriangleTest {
    /**
     * Method test triangle area calculation.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;

        assertThat(result, closeTo(expected, 0.1));
    }
}
