package simpleformprocess;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class BeerExpertTest.
 * Tests BeerExpert class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class BeerExpertTest {
    /**
     * Method tests obtaining brands.
     *
     * @throws Exception Exception.
     */
    @Test
    public void whenInvokeThenGetBrands() throws Exception {
        BeerExpert beerExpert = new BeerExpert();

        List expected = new ArrayList();
        expected.add("Jack Amber");
        expected.add("Red Moose");

        List result = beerExpert.getBrands("amber");

        assertThat(result, is(expected));
    }

}