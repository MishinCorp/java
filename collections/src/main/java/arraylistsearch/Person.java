package arraylistsearch;

/**
 * Class Person.
 * Implements entity Person.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.09.2018
 */
public class Person {
    /**
     * Name.
     */
    private String name;
    /**
     * Surname.
     */
    private String surname;
    /**
     * Phone.
     */
    private String phone;
    /**
     * Address.
     */
    private String address;

    /**
     * Constructor.
     *
     * @param pName     Name.
     * @param pSurname  Surname.
     * @param pPhone    Phone.
     * @param pAddress Аddress.
     */
    public Person(
            final String pName,
            final String pSurname,
            final String pPhone,
            final String pAddress) {

        this.name = pName;
        this.surname = pSurname;
        this.phone = pPhone;
        this.address = pAddress;
    }

    /**
     * Method gets name.
     *
     * @return Name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method gets surname.
     *
     * @return Surname.
     */
    public final String getSurname() {
        return this.surname;
    }

    /**
     * Method gets phone.
     *
     * @return Phone.
     */
    public final String getPhone() {
        return this.phone;
    }

    /**
     * Method gets address.
     *
     * @return Address.
     */
    public final String getAddress() {
        return this.address;
    }
}
