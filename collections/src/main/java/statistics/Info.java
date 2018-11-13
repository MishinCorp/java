package statistics;

/**
 * Class Info.
 * Implements entity Info.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class Info {
    /**
     * Add count.
     */
    private int addCount;
    /**
     * Rename count.
     */
    private int renameCount;
    /**
     * Remove count.
     */
    private int removeCount;

    /**
     * Constructor.
     *
     * @param pAddCount    Add count.
     * @param pRenameCount Rename count.
     * @param pRemoveCount Remove count.
     */
    public Info(
            final int pAddCount,
            final int pRenameCount,
            final int pRemoveCount) {

        this.addCount = pAddCount;
        this.renameCount = pRenameCount;
        this.removeCount = pRemoveCount;
    }

    /**
     * Method gets the add count.
     *
     * @return int.
     */
    public final int getAddCount() {
        return this.addCount;
    }

    /**
     * Method gets the rename count.
     *
     * @return int.
     */
    public final int getRenameCount() {
        return this.renameCount;
    }

    /**
     * Method gets the remove count.
     *
     * @return int.
     */
    public final int getRemoveCount() {
        return this.removeCount;
    }
}
