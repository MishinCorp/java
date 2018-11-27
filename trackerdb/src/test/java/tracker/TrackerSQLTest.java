package tracker;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class TrackerSQLTest.
 * Tests TrackerSQL.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.11.2018
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrackerSQLTest {
    private final String dbConfig = "sqlite.properties";
    private Connection db;
    private final String sqlConfig = "sqliteTestQueries.properties";
    private Properties sqlProperties = new Properties();

    /**
     * Methods creates connection to the db.
     */
    @Before
    public void init() {
        try (InputStream in = TrackerSQL.class.getClassLoader()
                .getResourceAsStream(this.dbConfig)) {
            Properties properties = new Properties();
            properties.load(in);

            Class.forName(properties.getProperty("driver-class-name"));
            this.db = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

            try (InputStream inSQL = TrackerSQL.class.getClassLoader()
                    .getResourceAsStream(sqlConfig)) {
                this.sqlProperties = new Properties();
                this.sqlProperties.load(inSQL);

            } catch (Exception e) {
            }

            String qCreateStructure = this.sqlProperties.getProperty("qCreate");

            try (PreparedStatement stCreateStructure = db
                    .prepareStatement(qCreateStructure)) {
                stCreateStructure.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    /**
     * Method wipe the table.
     */
    public void truncate() {
        String qTruncate = sqlProperties.getProperty("qTruncate");
        try (PreparedStatement stTruncate = db.prepareStatement(qTruncate)
        ) {
            stTruncate.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests connection to DB.
     */
    @Test
    public void whenChecksConnectionThenResultsTrue() {
        try (TrackerSQL db = new TrackerSQL(dbConfig)) {
            assertThat(db.init(), is(true));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test add() method.
     */
    @Test
    public void whenAddThenResultsTrue() {
        Item itemAdd = new Item("add", "desc", 123);

        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            Item item = conn.add(itemAdd);

            String qSelect = sqlProperties.getProperty("qSelectAll");
            String result = "";

            try (PreparedStatement stTruncate = db.prepareStatement(qSelect)
            ) {
                ResultSet rs = stTruncate.executeQuery();
                rs.next();
                result = rs.getString("name");

            } catch (Exception e) {
                e.printStackTrace();
            }

            assertThat(result, is(item.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests findAll() method.
     */
    @Test
    public void whenFindAllThenFetchAll() {
        Item itemSelect1 = new Item("select1", "desc", 123);
        Item itemSelect2 = new Item("select2", "desc", 123);
        ArrayList<Item> result = new ArrayList<>();
        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            conn.add(itemSelect1);
            conn.add(itemSelect2);
            result = conn.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result.size(), is(2));
    }

    /**
     * Tests replace() method.
     */
    @Test
    public void whenReplace() {
        Item item = new Item("item", "item", 123);
        Item itemOld = new Item("old", "old", 123);
        Item itemReplace = new Item("new12", "new", 123);
        int result = 0;
        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            conn.add(item);
            conn.add(itemOld);
            conn.replace(itemOld.getId(), itemReplace);
            String qSelect = sqlProperties.getProperty("qSelectReplace");
            try (PreparedStatement stSelect = db.prepareStatement(qSelect)) {
                ResultSet rs = stSelect.executeQuery();
                rs.next();
                result = rs.getInt(1);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result, is(1));
    }

    /**
     * Tests delete() method.
     */
    @Test
    public void whenDelete() {
        Item item1 = new Item("item1", "item1", 123);
        Item item2 = new Item("item2", "item2", 123);
        int result = 0;
        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            conn.add(item1);
            conn.add(item2);
            conn.delete(item1.getId());
            String qSelect = sqlProperties.getProperty("qSelectDelete");

            try (PreparedStatement stSelect = db.prepareStatement(qSelect)) {
                ResultSet rs = stSelect.executeQuery();
                rs.next();
                result = rs.getInt(1);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result, is(0));
    }

    /**
     * Tests findByName() method.
     */
    @Test
    public void whenFindByName() {
        Item itemSelect1 = new Item("select1", "desc", 123);
        Item itemSelect2 = new Item("select2", "desc", 123);
        Item itemSelect3 = new Item("select1", "desc", 123);
        ArrayList<Item> result = new ArrayList<>();
        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            conn.add(itemSelect1);
            conn.add(itemSelect2);
            conn.add(itemSelect3);
            result = conn.findByName(itemSelect1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result.size(), is(2));
    }

    /**
     * Tests findById() method.
     */
    @Test
    public void whenFindById() {
        Item itemSelect1 = new Item("select1", "desc", 123);
        Item itemSelect2 = new Item("select2", "desc", 123);
        Item itemSelect3 = new Item("select3", "desc", 123);
        Item result = null;
        try (TrackerSQL conn = new TrackerSQL(dbConfig)) {
            conn.init();
            truncate();
            conn.add(itemSelect1);
            conn.add(itemSelect2);
            conn.add(itemSelect3);
            result = conn.findById(itemSelect1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(result.getName(), is(itemSelect1.getName()));
    }
}