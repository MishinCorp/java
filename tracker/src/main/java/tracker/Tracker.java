package tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Tracker.
 * Implements Tracker entity.
 * Storage for all the items
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class Tracker {
    /**
     * Random range.
     */
    private static final int RANDOM_RANGE = 100;
    /**
     * Storage.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Method generates an ID.
     *
     * @return ID.
     */
    private String generateId() {
        Random random = new Random();

        return String.valueOf(
                System.currentTimeMillis()
                        + random.nextInt(RANDOM_RANGE));
    }

    /**
     * Method adds an item.
     *
     * @param anItem Item.
     * @return Item.
     */
    public final Item add(final Item anItem) {
        anItem.setId(this.generateId());
        this.items.add(anItem);

        return anItem;
    }

    /**
     * Method gets all the items.
     *
     * @return List.
     */
    public final ArrayList<Item> getAll() {
        return this.items;
    }

    /**
     * Method gets an item by id.
     *
     * @param anId Id.
     * @return Item.
     */
    public final Item findById(final String anId) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(anId)) {
                result = item;
                break;
            }
        }

        return result;
    }

    /**
     * Method gets an item by name.
     *
     * @param aKey Name.
     * @return Item.
     */
    public final ArrayList<Item> findByName(final String aKey) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(aKey)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Method edits an item.
     *
     * @param anId   Id.
     * @param anItem Item.
     */
    public final void replace(final String anId, final Item anItem) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(anId)) {
                this.items.set(i, anItem);
                this.items.get(i).setId(anId);
                break;
            }
        }
    }

    /**
     * Method removes an item.
     *
     * @param anId Id.
     */
    public final void delete(final String anId) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(anId)) {
                this.items.remove(i);
                break;
            }
        }
    }
}

