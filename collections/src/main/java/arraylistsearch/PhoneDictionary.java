package arraylistsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * @param pPerson Person.
     */
    public final void add(final Person pPerson) {
        this.persons.add(pPerson);
    }

    /**
     * Method searches persons by keyword.
     *
     * @param pKey Keyword.
     * @return List.
     */
    public final List<Person> find(final String pKey) {
        return this.persons.stream().filter(
                person -> person.getName().contains(pKey)
                        || person.getSurname().contains(pKey)
                        || person.getPhone().contains(pKey)
                        || person.getAddress().contains(pKey)).collect(Collectors.toList());


    }
}
