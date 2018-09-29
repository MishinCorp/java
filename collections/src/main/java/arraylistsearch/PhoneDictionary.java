package arraylistsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary.
 * Implements entity Dictionary.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.09.2018
 */
public class PhoneDictionary {
    /**
     * Storage.
     */
    private List<Person> persons = new ArrayList<>();

    /**
     * Method adds a person.
     *
     * @param aPerson Person.
     */
    public final void add(final Person aPerson) {
        this.persons.add(aPerson);
    }

    /**
     * Method searches persons by keyword.
     *
     * @param aKey Keyword.
     * @return List.
     */
    public final List<Person> find(final String aKey) {
        List<Person> result = new ArrayList<>();

//        for (Person person : persons) {
//            if (person.getName().contains(aKey)
//                    || person.getSurname().contains(aKey)
//                    || person.getPhone().contains(aKey)
//                    || person.getAddress().contains(aKey)) {
//
//                result.add(person);
//            }
//        }
        persons.iterator().forEachRemaining(person -> {
            if (person.getName().contains(aKey)
                    || person.getSurname().contains(aKey)
                    || person.getPhone().contains(aKey)
                    || person.getAddress().contains(aKey)) {
                result.add(person);
            }
        });

        return result;
    }
}
