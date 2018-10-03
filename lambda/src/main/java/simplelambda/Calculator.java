package simplelambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Class Calculator.
 * Implements simple calculator.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 02.10.2018
 */
public class Calculator {
    /**
     * @param aStart  Start number.
     * @param aFinish Finish number.
     * @param aValue  Value to operate.
     * @param op      Operation.
     * @param media   Output.
     */
    public final void multiple(
            final int aStart, final int aFinish, final int aValue,
            final BiFunction<Integer, Integer, Double> op,
            final Consumer<Double> media) {

        for (int index = aStart; index != aFinish; index++) {
            media.accept(op.apply(aValue, index));
        }
    }
}
