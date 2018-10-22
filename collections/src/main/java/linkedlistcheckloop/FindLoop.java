package linkedlistcheckloop;

/**
 * Class FindLoop.
 * Checks whether the list contains a loop.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class FindLoop {
    /**
     * Method checks the loop.
     *
     * @param pFirst First element.
     * @return boolean.
     */
    public final boolean hasCycle(final Node pFirst) {
        Node tortoise = pFirst;
        Node hare = pFirst;
        boolean result = false;

        while (hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if (tortoise == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}
