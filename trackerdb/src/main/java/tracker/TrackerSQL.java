package tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Class TrackerSQL.
 * Implements entity TrackerSQL.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.11.2018
 */
public class TrackerSQL implements ITracker, Closeable {
    /**
     * INDEX.
     */
    public static final int INDEX = 3;
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class);
    /**
     * Connection.
     */
    private Connection conn;
    /**
     * Config.
     */
    private String config;
    /**
     * SQL Properties.
     */
    private Properties sqlConfig = new Properties();

    /**
     * Constructor.
     *
     * @param pConfig Config file name.
     */
    public TrackerSQL(final String pConfig) {
        this.config = pConfig;


    }

    /**
     * Method initializes db connection.
     *
     * @return boolean.
     */
    public final boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader()
                .getResourceAsStream(this.config)) {
            Properties properties = new Properties();
            properties.load(in);

            Class.forName(properties.getProperty("driver-class-name"));
            LOG.info("JDBC driver is loaded");
            this.conn = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
            LOG.info("Data base is connected");

            try (InputStream inSQL = TrackerSQL.class.getClassLoader()
                    .getResourceAsStream("sql.properties")) {
                sqlConfig = new Properties();
                sqlConfig.load(inSQL);

            } catch (Exception e) {
                LOG.info(e.getMessage());
            }

            String qCreateStructure = sqlConfig.getProperty("qCreate");

            try (PreparedStatement stCreateStructure = conn
                    .prepareStatement(qCreateStructure)) {
                stCreateStructure.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            LOG.error("Exception!", e);
        }
        return this.conn != null;
    }

    @Override
    public final void close() throws IOException {
        try {
            this.conn.close();
            LOG.info("Data base is disconnected");
        } catch (SQLException e) {
            LOG.error("SQL error!", e);
        }
    }

    @Override
    public final Item add(final Item item) {
        String qInsert = sqlConfig.getProperty("qInsert");

        try (PreparedStatement stInsert = conn.prepareStatement(
                qInsert,
                Statement.RETURN_GENERATED_KEYS)) {

            stInsert.setString(1, item.getName());
            stInsert.setString(2, item.getDescription());
            int row = stInsert.executeUpdate();

            ResultSet rs = stInsert.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            item.setId(String.valueOf(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public final void replace(final String id, final Item item) {
        String qReplace = sqlConfig.getProperty("qUpdate");

        try (PreparedStatement stReplace = conn.prepareStatement(
                qReplace)) {

            stReplace.setString(1, item.getName());
            stReplace.setString(2, item.getDescription());
            stReplace.setInt(INDEX, Integer.valueOf(id));
            stReplace.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void delete(final String id) {
        String qDelete = sqlConfig.getProperty("qDelete");
        try (PreparedStatement stReplace = conn.prepareStatement(
                qDelete)) {

            stReplace.setInt(1, Integer.valueOf(id));
            stReplace.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        String qSelect = sqlConfig.getProperty("qFindAll");
        try (PreparedStatement stSelect = conn.prepareStatement(qSelect)) {

            ResultSet rs = stSelect.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        Long.valueOf(rs.getString("created")));
                item.setId(rs.getString("id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public final ArrayList<Item> findByName(final String key) {
        ArrayList<Item> result = new ArrayList<>();
        String qSelect = sqlConfig.getProperty("qFindByName");
        try (PreparedStatement stSelect = conn.prepareStatement(qSelect)
        ) {
            stSelect.setString(1, key);
            ResultSet rs = stSelect.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        Long.valueOf(rs.getString("created")));
                item.setId(rs.getString("id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public final Item findById(final String id) {
        Item item = null;
        String qSelect = sqlConfig.getProperty("qFindByID");
        try (PreparedStatement stSelect = conn.prepareStatement(qSelect)
        ) {
            stSelect.setInt(1, Integer.valueOf(id));
            ResultSet rs = stSelect.executeQuery();

            while (rs.next()) {
                item = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        Long.valueOf(rs.getString("created")));
                item.setId(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
