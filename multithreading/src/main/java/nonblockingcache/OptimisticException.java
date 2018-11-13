package nonblockingcache;

/**
 * Class OptimisticException.
 * Implements entity OptimisticException.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.10.2018
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructor.
     * @param pMsg Message.
     */
    public OptimisticException(final String pMsg) {
        super(pMsg);
    }
}
