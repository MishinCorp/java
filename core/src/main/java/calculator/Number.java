package calculator;

/**
 * Class Number.
 * Implements interface INumber.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class Number implements INumber {
    /**
     * Value.
     */
    private int i;

    /**
     * Constructor.
     *
     * @param aValue Value.
     */
    public Number(final int aValue) {
        this.i = aValue;
    }

    /**
     * Method set value.
     *
     * @param aNumber Value.
     */
    @Override
    public final void setValue(final int aNumber) {
        this.i = aNumber;
    }

    /**
     * Method gets value as string.
     *
     * @return String.
     */
    @Override
    public final String toString() {
        return String.valueOf(this.i);
    }

    /**
     * Method add arguments.
     *
     * @param aNumber an argument.
     * @return INumber.
     */
    @Override
    public final INumber add(final INumber aNumber) {
        this.i += Integer.valueOf(aNumber.toString());

        return this;
    }
}
