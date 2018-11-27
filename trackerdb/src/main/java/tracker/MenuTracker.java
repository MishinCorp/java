package tracker;

import java.util.ArrayList;

/**
 * Class EditItems. Extends BaseAction.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
class EditItems extends BaseAction {
    /**
     * Constructor.
     *
     * @param aKey  Action number.
     * @param aName Action name.
     */
    EditItems(final int aKey, final String aName) {
        super(aKey, aName);
    }

    /**
     * Method edits an item.
     *
     * @param anInput  Input.
     * @param aTracker Tracker.
     */
    @Override
    public void execute(final Input anInput, final ITracker aTracker) {
        System.out.println();
        System.out.println("------------ Обновление заявки --------------");

        String id = anInput.ask("Введите ID заявки : ");

        if (aTracker.findById(id) != null) {
            String name = anInput.ask("Введите имя заявки : ");
            String desc = anInput.ask("Введите описание заявки : ");
            Item item = new Item(name, desc, DATE);
            item.setId(id);
            aTracker.replace(id, item);

            System.out.println("------------ Заявка с ID "
                    + item.getId()
                    + " обновлена -----------");
            System.out.println();

        } else {
            System.out.println("------------"
                    + " Заявка с ID : "
                    + id
                    + " не найдена! -----------");
        }
    }
}

/**
 * Class MenuTracker.
 * Implements Menu entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public class MenuTracker {
    /**
     * ZERO.
     */
    public static final int ZERO = 0;
    /**
     * ONE.
     */
    public static final int ONE = 1;
    /**
     * TWO.
     */
    public static final int TWO = 2;
    /**
     * THREE.
     */
    public static final int THREE = 3;
    /**
     * FOUR.
     */
    public static final int FOUR = 4;
    /**
     * FIVE.
     */
    public static final int FIVE = 5;
    /**
     * SIX.
     */
    public static final int SIX = 6;
    /**
     * Input.
     */
    private Input input;
    /**
     * Tracker.
     */
    private ITracker tracker;
    /**
     * User actions list.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param anInput  Input.
     * @param aTracker Tracker.
     */
    public MenuTracker(final Input anInput, final ITracker aTracker) {
        this.input = anInput;
        this.tracker = aTracker;
    }

    /**
     * Method fills the menu.
     *
     * @param ui UI.
     */
    public final void fillActions(final StartUI ui) {
        // we use non-static inner class.
        this.actions.add(this.new AddItem(ZERO,
                "Добавить новую заявку"));
        // we use static inner class.
        this.actions.add(new ShowItems(ONE,
                "Показать все заявки"));
        // we use another class that locates in the same file.
        this.actions.add(new EditItems(TWO,
                "Редактировать заявку"));
        // we use non-static inner class.
        this.actions.add(this.new DeleteItem(THREE,
                "Удалить заявку"));
        this.actions.add(this.new FindItemById(FOUR,
                "Поиск заявки по ID"));
        this.actions.add(this.new FindItemByName(FIVE,
                "Поиск заявки по имени"));
        this.actions.add(this.new Exit(SIX, "Выход из программы", ui));
    }

    /**
     * Method gets menu keys.
     *
     * @return Array.
     */
    public final int[] menuKeys() {
        int[] result = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            result[i] = this.actions.get(i).key() + 1;
        }

        return result;
    }

    /**
     * Method executes an action.
     *
     * @param aKey Key.
     */
    public final void select(final int aKey) {
        this.actions.get(aKey - 1).execute(this.input, this.tracker);
    }

    /**
     * Method shows the menu.
     */
    public final void show() {
        System.out.println("Меню.");
        System.out.println("++++++++++++++++++++++++++++++");

        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Non-static inner class AddItem.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 22.09.2018
     */
    private class AddItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         */
        AddItem(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Method adds an item.
         *
         * @param anInput  Input.
         * @param aTracker Tracker.
         */
        @Override
        public final void execute(
                final Input anInput,
                final ITracker aTracker) {
            System.out.println();
            System.out.println("------------ "
                    + "Добавление новой заявки "
                    + "--------------");

            String name = anInput.ask("Введите имя заявки : ");
            String desc = anInput.ask("Введите описание заявки : ");
            aTracker.add(new Item(name, desc, DATE));

            System.out.println("------------ "
                    + "Заявка успешно добавлена "
                    + "-----------");
            System.out.println();
        }
    }

    /**
     * Static inner class ShowItems.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 24.09.2018
     */
    private static class ShowItems extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         */
        ShowItems(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Method outputs all the items.
         *
         * @param anInput  Input.
         * @param aTracker Tracker.
         */
        @Override
        public final void execute(
                final Input anInput,
                final ITracker aTracker) {
            System.out.println();
            ArrayList<Item> list = aTracker.findAll();
            if (list.size() > 0) {
                System.out.println("------------"
                        + " Все заявки"
                        + " --------------");

                for (Item item : list) {
                    System.out.println(String.format(
                            "%s. %s",
                            item.getId(),
                            item.getName()));
                }

                System.out.println("------------  -----------");
                System.out.println();
            } else {
                System.out.println("------------"
                        + " Заявок не обнаружено"
                        + " --------------");
            }
        }
    }

    /**
     * Non-static inner class DeleteItem.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 24.09.2018
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         */
        DeleteItem(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Method deletes an item.
         *
         * @param anInput  Item.
         * @param aTracker Tracker.
         */
        @Override
        public void execute(final Input anInput, final ITracker aTracker) {
            System.out.println();
            System.out.println("------------"
                    + " Удаление заявки"
                    + " --------------");

            String id = anInput.ask("Введите ID заявки : ");

            if (aTracker.findById(id) != null) {
                aTracker.delete(id);
                System.out.println("------------"
                        + " Заявка с ID : "
                        + id
                        + " удалена -----------");
                System.out.println();

            } else {
                System.out.println("------------"
                        + " Заявка с ID : "
                        + id
                        + " не найдена! -----------");
            }
        }
    }

    /**
     * Non-static inner class FindItemById.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 24.09.2018
     */
    private class FindItemById extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         */
        FindItemById(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Method fetches an item by id.
         *
         * @param anInput  Input.
         * @param aTracker Tracker.
         */
        @Override
        public void execute(final Input anInput, final ITracker aTracker) {
            System.out.println();
            System.out.println("------------"
                    + " Поиск заявки по id"
                    + " --------------");

            String id = anInput.ask("Введите ID заявки : ");
            Item item = aTracker.findById(id);

            if (item != null) {
                System.out.println("------------"
                        + " Заявка с ID : "
                        + id
                        + " найдена: -----------");
                System.out.println(String.format("%s. %s %s",
                        item.getId(), item.getName(), item.getDescription()));
                System.out.println();
            } else {
                System.out.println("------------"
                        + " Заявка с ID : "
                        + id
                        + " не найдена! -----------");
            }
        }
    }

    /**
     * Non-static inner class FindItemByName.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 24.09.2018
     */
    private class FindItemByName extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         */
        FindItemByName(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Method fetches an item by name.
         *
         * @param anInput  Input.
         * @param aTracker Tracker.
         */
        @Override
        public void execute(final Input anInput, final ITracker aTracker) {
            System.out.println();
            System.out.println("------------"
                    + " Поиск заявки по имени"
                    + " --------------");
            String name = anInput.ask("Введите имя заявки : ");
            System.out.println();
            ArrayList<Item> list = aTracker.findByName(name);
            if (list.size() > 0) {
                System.out.println("------------"
                        + " Все заявки c именем: "
                        + name
                        + " --------------");

                for (Item item : list) {
                    System.out.println(String.format(
                            "%s. %s %s",
                            item.getId(),
                            item.getName(),
                            item.getDescription()));
                }

                System.out.println();
            } else {
                System.out.println("------------"
                        + " Заявки c именем: "
                        + name
                        + " не обнаружено --------------");
            }
        }
    }

    /**
     * Non-static inner class Exit.
     *
     * @author Mishin Yura (mishin.inbox@gmail.com)
     * @since 27.09.2018
     */
    private class Exit extends BaseAction {
        /**
         * UI.
         */
        private StartUI ui;

        /**
         * Constructor.
         *
         * @param aKey  Action number.
         * @param aName Action name.
         * @param aUi   UI.
         */
        Exit(final int aKey, final String aName, final StartUI aUi) {
            super(aKey, aName);
            this.ui = aUi;
        }

        /**
         * Method performs an action..
         *
         * @param anInput  Input.
         * @param aTracker Tracker.
         */
        @Override
        public void execute(final Input anInput, final ITracker aTracker) {
            this.ui.stop();
        }
    }
}
