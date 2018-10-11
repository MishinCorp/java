package banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 * Implements entity Bank.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2018
 */
public class Bank {
    /**
     * Storage.
     */
    private Map<User, List<Account>> map = new HashMap<>();

    /**
     * Method gets Map.
     *
     * @return Map.
     */
    public final Map<User, List<Account>> getMap() {
        return this.map;
    }

    /**
     * Method adds a user.
     *
     * @param pUser User.
     */
    public final void addUser(final User pUser) {
        this.map.putIfAbsent(pUser, new ArrayList());
    }

    /**
     * Method removes the user.
     *
     * @param pUser User.
     */
    public final void deleteUser(final User pUser) {
        this.map.remove(pUser);
    }

    /**
     * Method adds an account for the user.
     *
     * @param pPassport Passport.
     * @param pAccount  Account.
     */
    public final void addAccountToUser(
            final String pPassport,
            final Account pAccount) {

        this.map.entrySet().stream().filter(entry ->
                entry.getKey().getPassport().equals(pPassport)
        ).forEach(entry -> entry.getValue().add(pAccount));
    }

    /**
     * Method removes an account.
     *
     * @param pPassport Passport.
     * @param pAccount  Account.
     */
    public final void deleteAccountFromUser(
            final String pPassport,
            final Account pAccount) {

        this.map.entrySet().stream()
                .filter(entry ->
                        entry.getKey().getPassport().equals(pPassport)
                )
                .forEach(entry -> entry.getValue()
                        .remove(entry.getValue().indexOf(pAccount)));
    }

    /**
     * Method gets the account list.
     *
     * @param pPassport Passport.
     * @return List.
     */
    public final List<Account> getUserAccounts(final String pPassport) {
        return this.map.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(pPassport))
                .findFirst().get().getValue();
    }

    /**
     * Method transfers money.
     *
     * @param pSrcPassport  Passport source.
     * @param pSrcRequisite Requisite source.
     * @param pDestPassport Passport destination.
     * @param pDstRequisite Requisite destination.
     * @param pAmount       Amount.
     * @return boolean.
     */
    public final boolean transferMoney(
            final String pSrcPassport,
            final String pSrcRequisite,
            final String pDestPassport,
            final String pDstRequisite,
            final double pAmount) {

        boolean result = false;
        boolean transferFrom;
        boolean transferTo;
        // Valids data.
        transferFrom = this.map.entrySet().stream()
                .filter(entry ->
                        entry.getKey().getPassport().equals(pSrcPassport))
                .anyMatch(entry -> {
                    return entry.getValue().stream()
                            .anyMatch(account -> {
                                boolean r = false;
                                if (account
                                        .getRequisites()
                                        .equals(pSrcRequisite)) {
                                    if (account.getValues() >= pAmount) {
                                        r = true;
                                    }
                                }
                                return r;
                            });
                });

        transferTo = this.map.entrySet().stream()
                .filter(entry ->
                        entry.getKey().getPassport()
                                .equals(pDestPassport))
                .anyMatch(entry -> {
                    return entry.getValue().stream()
                            .anyMatch(account ->
                                    account.getRequisites()
                                            .equals(pDstRequisite));
                });
        // Transfers.
        if (transferFrom && transferTo) {
            result = this.map.entrySet().stream()
                    .anyMatch(entry -> {
                        boolean r = false;
                        if (entry.getKey()
                                .getPassport()
                                .equals(pDestPassport)) {
                            r = entry.getValue().stream().anyMatch(account -> {
                                boolean rst = false;
                                if (account
                                        .getRequisites()
                                        .equals(pDstRequisite)) {
                                    account
                                            .setValues(account.getValues()
                                                    + pAmount);
                                    rst = true;
                                }
                                return rst;
                            });
                        }
                        return r;
                    });
        }
        return result;
    }
}
