package listtomap;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 * Implements List to Map convertation.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.10.2018
 */
public class UserConvert {
    /**
     * Method converts List to Map.
     *
     * @param aList List of User.
     * @return Map.
     */
    public final HashMap<Integer, User> process(final List<User> aList) {
        HashMap<Integer, User> result = new HashMap<>();
        aList.forEach(
                n -> result.put(n.getId(), n)
        );
        return result;
    }
}
