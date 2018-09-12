package simpleformprocess;

import java.util.List;

/**
 * Interface IBeerExpert.
 * Declares methods for getting brands.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public interface IBeerExpert {
    /**
     * Method get beer brands.
     *
     * @param aColor Color.
     * @return List.
     */
    List getBrands(final String aColor);
}
