package banktransfer;

/**
 * Class User.
 * Implements entity User.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2018
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Passport.
     */
    private String passport;
    /**
     * Hashcode const.
     */
    public static final int HASH = 31;

    @Override
    public final boolean equals(final Object pObject) {
        if (this == pObject) {
            return true;
        }
        if (pObject == null || getClass() != pObject.getClass()) {
            return false;
        }
        User user = (User) pObject;
        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    @Override
    public final int hashCode() {
        int result = this.name.hashCode();
        result = HASH * result + this.passport.hashCode();
        return result;
    }

    /**
     * Constructor.
     *
     * @param pName     Name.
     * @param pPassport Passport.
     */
    public User(final String pName, final String pPassport) {
        this.name = pName;
        this.passport = pPassport;
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
     * Method sets name.
     *
     * @param pName Name.
     */
    public final void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Method gets passport.
     *
     * @return Passport.
     */
    public final String getPassport() {
        return this.passport;
    }

    /**
     * Method sets passport.
     *
     * @param pPassport Passport.
     */
    public final void setPassport(final String pPassport) {
        this.passport = pPassport;
    }
}
