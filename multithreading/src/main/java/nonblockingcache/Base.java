package nonblockingcache;

/**
 * Class Base.
 * Implements entity Base.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.10.2018
 */
public class Base {
    /**
     * ID.
     */
    private volatile int id;
    /**
     * Version.
     */
    private volatile int version;
    /**
     * Name.
     */
    private volatile String name;

    /**
     * Constructor.
     *
     * @param pId      ID.
     * @param pVersion Version.
     * @param pName    Name.
     */
    public Base(final int pId, final int pVersion, final String pName) {
        this.id = pId;
        this.version = pVersion;
        this.name = pName;
    }

    /**
     * Constructor.
     *
     * @param pId   ID.
     * @param pName Name.
     */
    public Base(final int pId, final String pName) {
        this.id = pId;
        this.name = pName;
    }

    /**
     * ID getter.
     *
     * @return ID.
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Version getter.
     *
     * @return Version.
     */
    public final int getVersion() {
        return this.version;
    }

    /**
     * Version setter.
     *
     * @param pVersion Version.
     */
    public final void setVersion(final int pVersion) {
        this.version = pVersion;
    }

    /**
     * Name getter.
     *
     * @return Name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Name setter.
     *
     * @param pName Name.
     */
    public final void setName(final String pName) {
        this.name = pName;
    }
}
