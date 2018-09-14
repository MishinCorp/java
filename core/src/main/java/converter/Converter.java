package converter;

/**
 * Class Converter.
 * Currency exchanger.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 14.09.2018
 */
public class Converter {
    /**
     * USD_RATE.
     */
    private static final int USD_RATE = 60;
    /**
     * EURO_RATE.
     */
    private static final int EURO_RATE = 70;

    /**
     * Method converts RUB to EURO.
     *
     * @param aValue RUB.
     * @return EURO.
     */
    public final int rubleToEuro(final int aValue) {

        return aValue / EURO_RATE;
    }

    /**
     * Method converts RUB to USD.
     *
     * @param aValue RUB.
     * @return USD.
     */
    public final int rubleToDollar(final int aValue) {

        return aValue / USD_RATE;
    }

    /**
     * Method converts USD to RUB.
     *
     * @param aValue USD.
     * @return RUB.
     */
    public final int dollarToRuble(final int aValue) {

        return aValue * USD_RATE;
    }

    /**
     * Method converts EURO to USD.
     *
     * @param aValue EURO.
     * @return USD.
     */
    public final int euroToRuble(final int aValue) {

        return aValue * EURO_RATE;
    }
}
