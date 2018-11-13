package statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Store.
 * Implements entity Store.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.10.2018
 */
public class Store {
    /**
     * Class User.
     * Implements entity User.
     */
    static class User {
        /**
         * ID.
         */
        private int id;
        /**
         * Name.
         */
        private String name;

        /**
         * Constructor.
         *
         * @param pId   ID.
         * @param pName Name.
         */
        User(final int pId, final String pName) {
            this.name = pName;
            this.id = pId;
        }

        /**
         * Method gets ID.
         *
         * @return ID.
         */
        public final int getId() {
            return this.id;
        }

        /**
         * Method gets name.
         *
         * @return Name.
         */
        public final String getName() {
            return this.name;
        }
    }

    /**
     * Method creates statistics class.
     *
     * @param pPrevious Previous list.
     * @param pCurrent  Current list.
     * @return Info.
     */
    public final Info diff(
            final List<User> pPrevious,
            final List<User> pCurrent) {

        int addCount = 0;
        int renameCount = 0;
        int removeCount = 0;

        HashMap<Integer, String> mPrevious = new HashMap<>();
        for (User item : pPrevious) {
            mPrevious.put(item.getId(), item.getName());
        }
        HashMap<Integer, String> mCurrent = new HashMap<>();
        for (User item : pCurrent) {
            mCurrent.put(item.getId(), item.getName());
        }

        removeCount = mPrevious.size();
        for (Map.Entry<Integer, String> entry : mCurrent.entrySet()) {
            if (mPrevious.containsKey(entry.getKey())) {
                removeCount--;
            }
        }
        addCount = mCurrent.size();
        for (Map.Entry<Integer, String> entry : mPrevious.entrySet()) {
            if (mCurrent.containsKey(entry.getKey())) {
                addCount--;
            }
        }

        for (Map.Entry<Integer, String> entry : mPrevious.entrySet()) {
            Integer key = entry.getKey();

            if (mCurrent.containsKey(key)) {
                if (!entry.getValue().equals(mCurrent.get(key))) {
                    renameCount++;
                }
            }
        }
        return new Info(addCount, renameCount, removeCount);
    }
}
