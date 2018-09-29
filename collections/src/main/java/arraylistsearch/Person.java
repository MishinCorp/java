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
     * @param aName     Name.
     * @param aSurname  Surname.
     * @param aPhone    Phone.
     * @param anAddress Аddress.
     */
    public Person(
            final String aName,
            final String aSurname,
            final String aPhone,
            final String anAddress) {

        this.name = aName;
        this.surname = aSurname;
        this.phone = aPhone;
        this.address = anAddress;
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
