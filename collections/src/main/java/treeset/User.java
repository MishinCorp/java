package treeset;

/**
 * Class User.
 * Implements entity User.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.10.2018
 */
public class User implements Comparable<User> {
    /**
     * Hashcode var.
     */
    public static final int HASH = 31;
    /**
     * Name.
     */
    private String name;
    /**
     * Age.
     */
    private int age;

    /**
     * Constructor.
     *
     * @param pName Name.
     * @param pAge  Age.
     */
    public User(final String pName, final int pAge) {
        this.name = pName;
        this.age = pAge;
    }

//    /**
//     * Override toString().
//     *
//     * @return String.
//     */
//    @Override
//    public final String toString() {
//        return "User{" + "name='"
//                + this.name + '\''
//                + ", age=" + this.age
//                + '}';
//    }

    /**
     * Override equals().
     *
     * @param pObj Object.
     * @return boolean.
     */
    @Override
    public final boolean equals(final Object pObj) {
        boolean result;

        if (this == pObj) {
            result = true;
        }
        if (pObj == null || getClass() != pObj.getClass()) {
            result = false;
        }
        User user = (User) pObj;
        if (this.age != user.age) {
            result = false;
        }
        if (this.name != null) {
            result = this.name.equals(user.name);
        } else {
            result = user.name == null;
        }
        return result;
    }

    /**
     * Override hashCode().
     *
     * @return int.
     */
    @Override
    public final int hashCode() {
        int result = 0;
        if (this.name != null) {
            this.name.hashCode();
        }
        result = HASH * result + age;
        return result;
    }

    /**
     * Method gets name.
     *
     * @return name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method gets age.
     *
     * @return age.
     */
    public final int getAge() {
        return this.age;
    }

    /**
     * Override compareTo.
     * Sorts ascending by age.
     *
     * @param pUser User.
     * @return int.
     */
    @Override
    public final int compareTo(final User pUser) {
        return Integer.compare(this.getAge(), pUser.getAge());
    }
}
