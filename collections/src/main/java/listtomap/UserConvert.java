package listtomap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param pList List of User.
     * @return Map.
     */
    public final Map<Integer, User> process(final List<User> pList) {
        return pList.stream().collect(HashMap<Integer, User>::new,
                (k, v) -> k.put(v.getId(), v),
                (k, v) -> {
                }
        );
    }
}
