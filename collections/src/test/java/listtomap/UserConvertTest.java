package listtomap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserConvertTest.
 * Tests UserConvert class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.10.2018
 */
public class UserConvertTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Tests method process.
     */
    @Test
    public void whenProcessListThenResultMap() {
        User user0 = new User("Ivan0", "Moscow");
        User user1 = new User("Ivan1", "Moscow");
        User user2 = new User("Ivan2", "Moscow");

        List<User> list = new ArrayList<>();
        Collections.addAll(list, user0, user1, user2);

        UserConvert userConvert = new UserConvert();
        Map<Integer, User> map = userConvert.process(list);

        map.forEach(
                (k, v) -> System.out.println(String.format("%d %s %s", k, v.getName(), v.getCity()))
        );

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0 Ivan0 Moscow")
                                .append(System.lineSeparator())
                                .append("1 Ivan1 Moscow")
                                .append(System.lineSeparator())
                                .append("2 Ivan2 Moscow")
                                .append(System.lineSeparator())
                                .toString()));
    }
}
