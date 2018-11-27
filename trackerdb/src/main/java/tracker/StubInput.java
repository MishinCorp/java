package tracker;

/**
 * Class StubInput.
 * Emulates user's actions.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class StubInput implements Input {
    /**
     * Answers.
     */
    private String[] answers;
    /**
     * Current answer index.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param theAnswers Answers.
     */
    public StubInput(final String[] theAnswers) {
        this.answers = theAnswers;
    }

    /**
     * Method asks user and get his answer.
     *
     * @param aQuestion Question.
     * @return Reply.
     */
    public final String ask(final String aQuestion) {
        return answers[position++];
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
        return Integer.valueOf(this.ask(aQuestion));
    }
}
