package tracker;

/**
 * Interface UserAction.
 * Declares common methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.09.2018
 */
public interface UserAction {
    /**
     * Method returns action key.
     *
     * @return key Action key.
     */
    int key();

    /**
     * Method performs an action.
     *
     * @param anInput  Input.
     * @param aTracker Tracker.
     */
    void execute(Input anInput, Tracker aTracker);

    /**
     * Method shows info.
     *
     * @return Message.
     */
    String info();
}
