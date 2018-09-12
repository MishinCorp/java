package simpleformprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BeerExpert.
 * Implements IBeerExpert.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class BeerExpert implements IBeerExpert {
    /**
     * Method get beer brands.
     *
     * @param aColor Color.
     * @return List.
     */
    @Override
    public final List getBrands(final String aColor) {
        List result = new ArrayList();

        if (aColor.equals("amber")) {
            result.add("Jack Amber");
            result.add("Red Moose");

        } else {
            result.add("Jail Pale Ale");
            result.add("Gout Stout");
        }

        return result;
    }
}
