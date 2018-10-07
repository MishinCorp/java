package calcfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class Funcs.
 * Implements values calculation for functions.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 03.10.2018
 */
public class Funcs {
    /**
     * Method calculates values.
     *
     * @param pStart Start number.
     * @param pEnd   End number.
     * @param pFunc  Function formula.
     * @return List.
     */
    public final List<Double> range(
            final int pStart,
            final int pEnd,
            final Function<Double, Double> pFunc) {

        List<Double> result = new ArrayList<>();
        for (int i = pStart; i <= pEnd; i++) {
            result.add(pFunc.apply((double) i));
        }
        return result;
    }
}
