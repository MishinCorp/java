package listtomap;

/**
 * Class User.
 * Implements entity User.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.10.2018
 */
public class User {
    /**
     * ID.
     */
    private int id;
    /**
     * Name.
     */
    private String name;
    /**
     * City.
     */
    private String city;
    /**
     * Count.
     */
    private static int count;

    /**
     * Constructor.
     *
     * @param aName User name.
     * @param aCity City.
     */
    public User(final String aName, final String aCity) {
        this.name = aName;
        this.city = aCity;
        this.id = count++;
    }

    /**
     * ID getter.
     *
     * @return ID.
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Name getter.
     *
     * @return Name.
     */

    public final String getName() {
        return this.name;
    }

    /**
     * City getter.
     *
     * @return City.
     */
    public final String getCity() {
        return this.city;
    }
}
