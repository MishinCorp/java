package tracker;

/**
 * Class StartUI.
 * App starts here.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class StartUI {
    /**
     * Exit flag.
     */
    private boolean working = true;
    /**
     * Input type.
     */
    private final Input input;
    /**
     * Tracker.
     */
    private final Tracker tracker;

    /**
     * Constructor.
     *
     * @param anInput  Input.
     * @param aTracker Tracker.
     */
    public StartUI(final Input anInput, final Tracker aTracker) {
        this.input = anInput;
        this.tracker = aTracker;
    }

    /**
     * Method implements main cycle.
     */
    public final void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println();
            int key = input.ask("Выбор: ", menu.menuKeys());
            menu.select(key);
        } while (this.working);
    }

    /**
     * Method stops the menu cycle.
     */
    public final void stop() {
        this.working = false;
    }

    /**
     * Method launches the app.
     *
     * @param args CLI args.
     */
    public static void main(final String[] args) {
        new StartUI(
                new ValidateInput(new ConsoleInput()),
                new Tracker()).init();
    }
}
