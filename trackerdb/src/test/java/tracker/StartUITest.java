package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest.
 * Tests StartUI class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Tracker tracker = new Tracker();
    private final Item item1 = new Item("test1", "desc1", 123L);
    private final Item item2 = new Item("test2", "desc2", 123L);
    private final Item item3 = new Item("test1", "desc3", 123L);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));

        this.tracker.add(item1);
        this.tracker.add(item2);
        this.tracker.add(item3);
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Tests add item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"1", "test4", "desc", "7"});

        new StartUI(input, this.tracker).init();
    }

    /**
     * Tests showing all items.
     */
    @Test
    public void whenShowAllItems() {
        Input input = new StubInput(new String[]{"2", "7"});

        new StartUI(input, this.tracker).init();

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append("1. Добавить новую заявку")
                                .append(System.lineSeparator())
                                .append("2. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("3. Редактировать заявку")
                                .append(System.lineSeparator())
                                .append("4. Удалить заявку")
                                .append(System.lineSeparator())
                                .append("5. Поиск заявки по ID")
                                .append(System.lineSeparator())
                                .append("6. Поиск заявки по имени")
                                .append(System.lineSeparator())
                                .append("7. Выход из программы")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("------------ Все заявки --------------")
                                .append(System.lineSeparator())
                                .append(this.item1.getId() + ". " + this.item1.getName())
                                .append(System.lineSeparator())
                                .append(this.item2.getId() + ". " + this.item2.getName())
                                .append(System.lineSeparator())
                                .append(this.item3.getId() + ". " + this.item3.getName())
                                .append(System.lineSeparator())
                                .append("------------  -----------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append("1. Добавить новую заявку")
                                .append(System.lineSeparator())
                                .append("2. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("3. Редактировать заявку")
                                .append(System.lineSeparator())
                                .append("4. Удалить заявку")
                                .append(System.lineSeparator())
                                .append("5. Поиск заявки по ID")
                                .append(System.lineSeparator())
                                .append("6. Поиск заявки по имени")
                                .append(System.lineSeparator())
                                .append("7. Выход из программы")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Tests edit item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"3", this.item1.getId(), "test name", "desc", "7"});

        new StartUI(input, this.tracker).init();

        assertThat(this.tracker.findById(this.item1.getId()).getName(), is("test name"));
    }

    /**
     * Tests removal item.
     */
    @Test
    public void whenDeleteThenTrackerDoesNotHaveDeletedValue() {
        Input input = new StubInput(new String[]{"4", this.item1.getId(), "7"});

        new StartUI(input, this.tracker).init();

        assertNull(this.tracker.findById(this.item1.getId()));
    }

    /**
     * Test search item by id.
     */
    @Test
    public void whenSearchByIdThenTrackerHasValue() {
        Input input = new StubInput(new String[]{"5", this.item1.getId(), "7"});

        new StartUI(input, this.tracker).init();

        assertThat(this.tracker.findById(this.item1.getId()).getName(), is("test1"));
    }

    /**
     * Test search item by name.
     */
    @Test
    public void whenSearchByName() {
        Input input = new StubInput(new String[]{"6", "test1", "7"});

        new StartUI(input, this.tracker).init();

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append("1. Добавить новую заявку")
                                .append(System.lineSeparator())
                                .append("2. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("3. Редактировать заявку")
                                .append(System.lineSeparator())
                                .append("4. Удалить заявку")
                                .append(System.lineSeparator())
                                .append("5. Поиск заявки по ID")
                                .append(System.lineSeparator())
                                .append("6. Поиск заявки по имени")
                                .append(System.lineSeparator())
                                .append("7. Выход из программы")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("------------ Поиск заявки по имени --------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("------------ Все заявки c именем: test1 --------------")
                                .append(System.lineSeparator())
                                .append(this.item1.getId() + ". " + this.item1.getName() + " " + this.item1.getDescription())
                                .append(System.lineSeparator())
                                .append(this.item3.getId() + ". " + this.item3.getName() + " " + this.item3.getDescription())
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append("1. Добавить новую заявку")
                                .append(System.lineSeparator())
                                .append("2. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("3. Редактировать заявку")
                                .append(System.lineSeparator())
                                .append("4. Удалить заявку")
                                .append(System.lineSeparator())
                                .append("5. Поиск заявки по ID")
                                .append(System.lineSeparator())
                                .append("6. Поиск заявки по имени")
                                .append(System.lineSeparator())
                                .append("7. Выход из программы")
                                .append(System.lineSeparator())
                                .append("++++++++++++++++++++++++++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
