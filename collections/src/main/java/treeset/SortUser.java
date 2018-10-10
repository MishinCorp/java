package treeset;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class User.
 * Sorts users.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.10.2018
 */
public class SortUser {
    /**
     * Method converts List into Set.
     *
     * @param pUsers List.
     * @return Set.
     */
    public final Set<User> sort(final List<User> pUsers) {
        return pUsers.stream().collect(Collectors.toSet());
    }

    /**
     * Class SortByNameLength.
     * Implements Comparator that sorts items by name length.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 10.10.2018
     */
    class SortByNameLength implements Comparator<User> {
        @Override
        public final int compare(final User pFirst, final User pSecond) {
            return Integer.compare(
                    pFirst.getName().length(),
                    pSecond.getName().length());
        }
    }

    /**
     * Method sorts list by name length.
     *
     * @param pList List.
     * @return List.
     */
    public final List<User> sortNameLength(final List<User> pList) {
        return pList.stream()
                .sorted(new SortByNameLength())
                .collect(Collectors.toList());
    }

    /**
     * Class SortByNameLength.
     * Implements Comparator that sorts items by name length.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 10.10.2018
     */
    class SortByNameThenByAge implements Comparator<User> {
        @Override
        public int compare(final User pFirst, final User pSecond) {
            int result = pFirst.getName().compareTo(pSecond.getName());
            if (result == 0) {
                result = Integer.compare(pFirst.getAge(), pSecond.getAge());
            }
            return result;
        }
    }

    /**
     * Method sorts by name, then by age.
     *
     * @param pList List.
     * @return List.
     */
    public final List<User> sortByAllFields(final List<User> pList) {
        return pList.stream()
                .sorted(new SortByNameThenByAge())
                .collect(Collectors.toList());
    }
}
