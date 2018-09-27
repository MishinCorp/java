package tracker;

/**
 * Class ValidateInput.
 * Implements Input interface and validates datas.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.09.2018
 */
public class ValidateInput implements Input {
    /**
     * Input.
     */
    private final Input input;

    /**
     * Constructor.
     *
     * @param anInput Input.
     */
    public ValidateInput(final Input anInput) {
        this.input = anInput;
    }

    /**
     * Method asks user and get his answer.
     *
     * @param aQuestion Question.
     * @return Reply.
     */
    @Override
    public final String ask(final String aQuestion) {
        return this.input.ask(aQuestion);
    }

    /**
     * Method asks user and get his answer..
     * Overloaded.
     *
     * @param aQuestion Question.
     * @param aRange    Replies.
     * @return Reply.
     */
    @Override
    public final int ask(final String aQuestion, final int[] aRange) {
        boolean invalid = true;
        int value = -1;

        do {
            try {
                value = this.input.ask(aQuestion, aRange);
                invalid = false;

            } catch (NumberFormatException nfe) {
                System.out.println("Внимание!"
                        + " Необходимо ввести корректное значение."
                        + " Повторите ввод =)");
                System.out.println();
            } catch (MenuOutException moe) {
                System.out.println("Внимание!"
                        + " Необходимо выбрать значение из диапазона меню."
                        + " Повторите ввод =)");
                System.out.println();
            }
        } while (invalid);

        return value;
    }
}
