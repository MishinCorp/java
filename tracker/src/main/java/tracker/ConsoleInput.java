package tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 * Implements Input interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public class ConsoleInput implements Input {
    /**
     * Console input class.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method asks user and get his answer.
     *
     * @param aQuestion Question.
     * @return Reply.
     */
    public final String ask(final String aQuestion) {
        System.out.print(aQuestion);

        return scanner.nextLine();
    }

    /**
     * Method asks user and get his answer..
     * Overloaded.
     *
     * @param aQuestion Question.
     * @param aRange    Replies.
     * @return Reply.
     */
    public final int ask(final String aQuestion, final int[] aRange) {
        int key = Integer.valueOf(this.ask(aQuestion));
        boolean exist = false;
        for (int value : aRange) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }

        return key;
    }
}
