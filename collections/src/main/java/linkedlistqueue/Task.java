package linkedlistqueue;

/**
 * Class Task.
 * Implements entity Task.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.09.2018
 */
public class Task {
    /**
     * Description.
     */
    private String desc;
    /**
     * Priority.
     */
    private int priority;

    /**
     * Constructor.
     *
     * @param aDesc     Description.
     * @param aPriority Priority.
     */
    public Task(final String aDesc, final int aPriority) {
        this.desc = aDesc;
        this.priority = aPriority;
    }

    /**
     * Method gets description.
     *
     * @return Description.
     */
    public final String getDesc() {
        return this.desc;
    }

    /**
     * Method gets priority.
     *
     * @return Priority.
     */
    public final int getPriority() {
        return this.priority;
    }
}
