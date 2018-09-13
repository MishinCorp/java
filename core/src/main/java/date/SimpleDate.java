package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class SimpleDate.
 * Implements ISimpleDate.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class SimpleDate implements ISimpleDate {
    /**
     * Method return current month.
     *
     * @return String.
     */
    @Override
    public final String getMonth() {
        String format = "MMMM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format,
                Locale.ENGLISH);

        return dateFormat.format(new Date());
    }
}
