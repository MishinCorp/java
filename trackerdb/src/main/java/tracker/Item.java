package tracker;

/**
 * Class Item.
 * Implements Item entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public class Item {
    /**
     * ID.
     */
    private String id;
    /**
     * Name.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * Date created.
     */
    private long created;
    /**
     * Comments.
     */
    private String[] comments;

    /**
     * Constructor.
     *
     * @param aName        Name.
     * @param aDescription Description.
     * @param aCreatedDate Date created.
     */
    public Item(final String aName,
                final String aDescription,
                final long aCreatedDate) {
        this.name = aName;
        this.description = aDescription;
        this.created = aCreatedDate;
    }

    /**
     * ID getter.
     *
     * @return id.
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Description getter.
     *
     * @return description.
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * ID setter.
     *
     * @param anId ID.
     */
    public final void setId(final String anId) {
        this.id = anId;
    }
}
