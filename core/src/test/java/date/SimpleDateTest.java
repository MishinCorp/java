package date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Class SimpleDateTest.
 * Tests SimpleDate class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class SimpleDateTest {
    /**
     * Method test current month obtaining.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetCurrentMonth() throws Exception {
        SimpleDate date = new SimpleDate();
        String format = "MMMM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);

        String expected = dateFormat.format(new Date());
        String result = date.getMonth();

        assertThat(result, is(expected));
    }
}