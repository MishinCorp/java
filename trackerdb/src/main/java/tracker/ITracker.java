package tracker;

import java.util.ArrayList;

/**
 * Interface ITracker.
 * Declares entity ITracker.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.11.2018
 */
interface ITracker {
    /**
     * Method adds an item.
     *
     * @param pItem Item.
     * @return Item.
     */
    Item add(Item pItem);
    /**
     * Method edits an item.
     *
     * @param pId   Id.
     * @param pItem Item.
     */
    void replace(String pId, Item pItem);
    /**
     * Method removes an item.
     *
     * @param pId Id.
     */
    void delete(String pId);

    /**
     * Method gets all the items.
     *
     * @return List.
     */
    ArrayList<Item> findAll();
    /**
     * Method gets an item by name.
     *
     * @param pKey Name.
     * @return Item.
     */
    ArrayList<Item> findByName(String pKey);
    /**
     * Method gets an item by id.
     *
     * @param pId Id.
     * @return Item.
     */
    Item findById(String pId);
}
