package calculator;

/**
 * Interface INumber.
 * Declares methods for calculator.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public interface INumber {
    /**
     * Method set value.
     *
     * @param aNumber Value.
     */
    void setValue(final int aNumber);

    /**
     * Method gets value as string.
     *
     * @return String.
     */
    String toString();

    /**
     * Method add arguments.
     *
     * @param aNumber an argument.
     * @return INumber.
     */
    INumber add(final INumber aNumber);
}
