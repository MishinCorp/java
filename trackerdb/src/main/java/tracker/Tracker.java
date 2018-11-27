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
public class Tracker implements ITracker {
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
     * @param pItem Item.
     * @return Item.
     */
    public final Item add(final Item pItem) {
        pItem.setId(this.generateId());
        this.items.add(pItem);

        return pItem;
    }

    /**
     * Method gets all the items.
     *
     * @return List.
     */
    public final ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Method gets an item by id.
     *
     * @param pId Id.
     * @return Item.
     */
    public final Item findById(final String pId) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(pId)) {
                result = item;
                break;
            }
        }

        return result;
    }

    /**
     * Method gets an item by name.
     *
     * @param pKey Name.
     * @return Item.
     */
    public final ArrayList<Item> findByName(final String pKey) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(pKey)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Method edits an item.
     *
     * @param pId   Id.
     * @param pItem Item.
     */
    public final void replace(final String pId, final Item pItem) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(pId)) {
                this.items.set(i, pItem);
                this.items.get(i).setId(pId);
                break;
            }
        }
    }

    /**
     * Method removes an item.
     *
     * @param pId Id.
     */
    public final void delete(final String pId) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(pId)) {
                this.items.remove(i);
                break;
            }
        }
    }
}

