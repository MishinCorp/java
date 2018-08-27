package start;

import helloworld.HelloUser;

/**
 * Class Main.
 * Starts the app.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2018
 */
public final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Method contains start point.
     *
     * @param args Args.
     */
    public static void main(final String[] args) {
        System.out.println(new HelloUser().getGreeting("Yura"));
    }
}
