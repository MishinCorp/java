package banktransfer;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BankTest.
 * Tests Bank class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2018
 */
public class BankTest {
    private Bank bank = new Bank();

    /**
     * Tests addUser() method.
     */
    @Test
    public void whenInvokeThenAddUser() {
        User user = new User("Ivanov", "123");
        this.bank.addUser(user);
        boolean result = this.bank.getMap().entrySet().stream().anyMatch(entry -> entry.getKey().equals(user));
        boolean expected = true;

        assertThat(result, is(expected));
    }

    /**
     * Tests deleteUser() method.
     */
    @Test
    public void whenInvokeThenDeleteUser() {
        User user = new User("Ivanov", "123");
        this.bank.addUser(user);
        this.bank.deleteUser(user);
        boolean result = this.bank.getMap().entrySet().stream().anyMatch(entry -> entry.getKey().equals(user));
        boolean expected = false;

        assertThat(result, is(expected));
    }

    /**
     * Tests addAccountToUser() method.
     */
    @Test
    public void whenInvokeThenAddAccount() {
        User user1 = new User("Ivanov", "123");
        this.bank.addUser(user1);
        Account account = new Account("111", 0);
        int result;
        this.bank.addAccountToUser(user1.getPassport(), account);
        result = this.bank.getMap().entrySet().stream()
                .filter(entry ->
                        entry.getKey().getPassport().equals(user1.getPassport())
                )
                .findFirst()
                .get()
                .getValue()
                .indexOf(account);
        int expected = 0;

        assertThat(result, is(expected));
    }

    /**
     * Tests getUserAccounts() method.
     */
    @Test
    public void whenInvokeThenGetAllUserAccounts() {
        User user = new User("Ivanov", "123");
        this.bank.addUser(user);
        Account account = new Account("111", 0);
        this.bank.addAccountToUser(user.getPassport(), account);
        List<Account> accounts = this.bank.getUserAccounts(user.getPassport());
        int result = (int) accounts.stream().count();
        int expected = 1;

        assertThat(result, is(expected));
    }

    /**
     * Tests transferMoney() method.
     */
    @Test
    public void whenTransferMoneyIsOkThenResultTrue() {
        // Source.
        User userFrom = new User("Ivanov", "123");
        this.bank.addUser(userFrom);
        Account accountIvanov = new Account("111", 100);
        this.bank.addAccountToUser(userFrom.getPassport(), accountIvanov);

        // Destination.
        User userTo = new User("Petrov", "456");
        this.bank.addUser(userTo);
        Account accountPetrov = new Account("222", 1);
        this.bank.addAccountToUser(userTo.getPassport(), accountPetrov);

        boolean result = this.bank.transferMoney(
                userFrom.getPassport(), "111",
                userTo.getPassport(), "222",
                100);

        boolean expected = true;

        assertThat(result, is(expected));
    }

    /**
     * Tests transferMoney() method.
     */
    @Test
    public void whenSrcRequisitesInvalidThenResultFalse() {
        // Source.
        User userFrom = new User("Ivanov", "123");
        this.bank.addUser(userFrom);
        Account accountIvanov = new Account("111", 100);
        this.bank.addAccountToUser(userFrom.getPassport(), accountIvanov);

        // Destination.
        User userTo = new User("Petrov", "456");
        this.bank.addUser(userTo);
        Account accountPetrov = new Account("222", 1);
        this.bank.addAccountToUser(userTo.getPassport(), accountPetrov);

        boolean result = this.bank.transferMoney(
                userFrom.getPassport(), "100",
                userTo.getPassport(), "222",
                100);

        boolean expected = false;

        assertThat(result, is(expected));
    }

    /**
     * Tests transferMoney() method..
     */
    @Test
    public void whenSrcAmountInvalidThanResultFalse() {
        // Source.
        User userFrom = new User("Ivanov", "123");
        this.bank.addUser(userFrom);
        Account accountIvanov = new Account("111", 10);
        this.bank.addAccountToUser(userFrom.getPassport(), accountIvanov);

        // Destination.
        User userTo = new User("Petrov", "456");
        this.bank.addUser(userTo);
        Account accountPetrov = new Account("222", 1);
        this.bank.addAccountToUser(userTo.getPassport(), accountPetrov);

        boolean result = this.bank.transferMoney(
                userFrom.getPassport(), "111",
                userTo.getPassport(), "222",
                100);

        boolean expected = false;

        assertThat(result, is(expected));
    }
}
