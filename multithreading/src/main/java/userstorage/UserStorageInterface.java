package userstorage;

/**
 * Interface UserStorageInterface.
 * Declares data structure to store Users.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.10.2018
 */
public interface UserStorageInterface {
    /**
     * Method adds a user.
     *
     * @param pUser User.
     * @return boolean.
     */
    boolean add(User pUser);

    /**
     * Method updates user datas.
     *
     * @param pUser    User.
     * @param pUpCount Sum.
     * @return boolean.
     */
    boolean update(User pUser, int pUpCount);

    /**
     * Method removes user.
     *
     * @param pUser User.
     * @return boolean.
     */
    boolean delete(User pUser);

    /**
     * Method transfers money.
     *
     * @param pFromId FromID.
     * @param pToId   ToID.
     * @param pAmount Amount.
     * @return boolean.
     */
    boolean transfer(int pFromId, int pToId, int pAmount);
}
