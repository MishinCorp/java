package converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterTest.
 * Tests Converter class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 14.09.2018
 */
public class ConverterTest {
    /**
     * Method tests RUB to USD conversion.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);

        assertThat(result, is(1));
    }

    /**
     * Method tests RUB to EURO conversion.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);

        assertThat(result, is(1));
    }

    /**
     * Method tests USD to RUB conversion.
     */
    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);

        assertThat(result, is(60));
    }

    /**
     * Method tests EURO to RUB conversion.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);

        assertThat(result, is(70));
    }
}