package fitness;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class FitTest.
 * Tests Fit class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 16.09.2018
 */
public class FitTest {
    /**
     * Method tests manWeight method.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Method tests womanWeight method.
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}