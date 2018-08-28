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
    public String getGreeting(final String aName) {
        String result;

        switch (aName) {
            case "":
                throw new RuntimeException();
            case "Mishin":
                result = String.format("Hello, Yura %s!", aName);
                break;
            case "User":
                result = String.format("Hello, my %s!", aName);
                break;

            default:
                result = String.format("Hello, %s!", aName);
                break;
        }

        return result;
    }
}
