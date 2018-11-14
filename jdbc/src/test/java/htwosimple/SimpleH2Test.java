package htwosimple;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleH2Test.
 * Tests SimpleH2 class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 14.11.2018
 */
public class SimpleH2Test {
    /**
     * Tests init() and createInsert() methods.
     */
    @Test
    public void whenInvokeThenCreateTableWithOneEntry() {
        boolean result = false;

        try (SimpleH2 db = new SimpleH2()) {
            db.init();
            result = db.createInsert("Yura");

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result, is(true));
    }
}