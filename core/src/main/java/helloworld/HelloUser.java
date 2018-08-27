package helloworld;

/**
 * Class HelloUser.
 * Shows greeting.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2018
 */
public class HelloUser {
    /**
     * Method shows greeting.
     *
     * @param aName User name.
     * @return Greeting.
     */
    public final String getGreeting(final String aName) {
        return String.format("Hello, %s!", aName);
    }
}
