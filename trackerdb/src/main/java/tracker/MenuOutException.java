package tracker;

/**
 * Class MenuOutException.
 * Extends RuntimeException.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg Message.
     */
    public MenuOutException(final String msg) {
        super(msg);
    }
}
