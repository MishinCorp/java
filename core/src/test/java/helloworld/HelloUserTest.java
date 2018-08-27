package helloworld;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class HelloUserTest.
 * Tests HelloUser class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2018
 */
public class HelloUserTest {
    /**
     * Method gets greeting.
     */
    @Test
    public void whenGetGreetingThenGetString() {
        assertThat(new HelloUser().getGreeting("Yura"), is("Hello, Yura!"));
    }
}