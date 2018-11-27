package tracker;

/**
 * Interface Input.
 * Declares input methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 22.09.2018
 */
public interface Input {
    /**
     * Method asks user and get his answer.
     *
     * @param aQuestion Question.
     * @return Reply.
     */
    String ask(String aQuestion);

    /**
     * Method asks user and get his answer..
     * Overloaded.
     *
     * @param aQuestion Question.
     * @param aRange    Replies.
     * @return Reply.
     */
    int ask(String aQuestion, int[] aRange);
}
