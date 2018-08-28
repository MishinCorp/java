package start;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Class MainTest.
 * Tests Main class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2018
 */
public class MainTest {
    /**
     * Method tests new object creation.
     */
    @Test
    public void whenMainThenReturnTrue() throws Exception {
        assertNotNull(new Main());
    }

    /**
     * Method tests app launch.
     */
    @Test
    public void whenRunMain() throws Exception {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String param = "Yura";
        Main.main(param);

        System.setOut(stdout);

        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("Hello, ")
                .append(param)
                .append("!")
                .append(System.lineSeparator())
                .toString();

        assertThat(result, is(expected));
    }
}