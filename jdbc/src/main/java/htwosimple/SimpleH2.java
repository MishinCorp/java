package htwosimple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class SimpleH2.
 * Implements entity SimpleH2.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.11.2018
 */
public class SimpleH2 implements Closeable {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SimpleH2.class);
    /**
     * Connection.
     */
    private Connection db;

    /**
     * Method inits the connection.
     */
    public final void init() {
        try (InputStream in = SimpleH2.class.getClassLoader()
                .getResourceAsStream("appH2.properties")) {

            Properties properties = new Properties();
            properties.load(in);
            Class.forName(properties.getProperty("driver-class-name"));
            LOG.info("JDBC driver is loaded");
            db = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
            LOG.info("Data base is connected");

        } catch (Exception e) {
            LOG.error("Exception!", e);
        }
    }

    @Override
    public final void close() throws IOException {
        try {
            db.close();
            LOG.info("Connection is closed");
        } catch (SQLException e) {
            LOG.info(e.getMessage());
        }
    }

    /**
     * Method create table and insert an entry.
     *
     * @param name Name.
     * @return boolean.
     */
    public final boolean createInsert(final String name) {
        boolean result = false;
        String qCreate = "CREATE TABLE IF NOT EXISTS name (\n"
                + "  id   INT AUTO_INCREMENT PRIMARY KEY,\n"
                + "  name VARCHAR(50)\n"
                + ");";
        try (PreparedStatement stCreate = db.prepareStatement(qCreate)) {
            stCreate.executeUpdate();
            result = true;

        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

        String qInsert = "INSERT INTO NAME (NAME) VALUES (?);";
        try (PreparedStatement stInsert = db.prepareStatement(qInsert)) {
            stInsert.setString(1, name);
            stInsert.executeUpdate();
            result = true;

        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
        return result;
    }
}
