package simplecalc;

/**
 * Class Calculator.
 * Implements simple calculator methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 14.09.2018
 */
public class Calculator {
    /**
     * Result.
     */
    private double result;

    /**
     * Method peforms addition.
     *
     * @param first  arg.
     * @param second arg.
     */
    public final void add(final double first, final double second) {
        this.result = first + second;
    }

    /**
     * Method peforms subtraction.
     *
     * @param first  arg.
     * @param second arg.
     */
    public final void subtract(final double first, final double second) {
        this.result = first - second;
    }

    /**
     * Method peforms division.
     *
     * @param first  arg.
     * @param second arg.
     */
    public final void div(final double first, final double second) {
        this.result = first / second;
    }

    /**
     * Method peforms multiplication.
     *
     * @param first  arg.
     * @param second arg.
     */
    public final void multiple(final double first, final double second) {
        this.result = first * second;
    }

    /**
     * Method get result.
     *
     * @return result.
     */
    public final double getResult() {
        return this.result;
    }
}
