package userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;

/**
 * Class UserStorage.
 * Implements UserStorageInterface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
@ThreadSafe
public class UserStorage implements UserStorageInterface {
    /**
     * Storage.
     */
    @GuardedBy("this")
    private ArrayList<User> list = new ArrayList<>();

    @Override
    public final boolean add(final User pUser) {
        boolean result = false;
        if (!this.list.contains(pUser)) {
            synchronized (this) {
                this.list.add(pUser);
            }
            result = true;
        }
        return result;
    }

    @Override
    public final boolean update(final User pUser, final int pUpCount) {
        boolean result = false;
        if (this.list.contains(pUser)) {
            synchronized (this) {
                User item = this.list.get(this.list.indexOf(pUser));
                item.setAmount(item.getAmount() + pUpCount);
            }
            result = true;
        }
        return result;
    }

    @Override
    public final boolean delete(final User pUser) {
        boolean result = false;
        if (this.list.contains(pUser)) {
            synchronized (this) {
                this.list.remove(pUser);
            }
            result = true;
        }
        return result;
    }

    @Override
    public final boolean transfer(
            final int pFromId,
            final int pToId,
            final int pAmount) {

        boolean result = false;


        User fromUser = null;
        User toUser = null;

        for (User item : this.list) {
            if (item.getId() == pFromId) {
                fromUser = item;
            }
            if (item.getId() == pToId) {
                toUser = item;
            }
        }

        if (fromUser != null && toUser != null) {
            synchronized (this) {
                fromUser.setAmount(fromUser.getAmount() - pAmount);
                toUser.setAmount(toUser.getAmount() + pAmount);
            }
            result = true;
        }

        return result;
    }
}
