package pseudographics;

import java.util.function.BiPredicate;

/**
 * Class Paint.
 * Builds pyramid.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class Paint {
    /**
     * Method draws the right side.
     *
     * @param aHeight Height.
     * @return String.
     */
    public final String rightTrl(final int aHeight) {
        return this.loopBy(
                aHeight,
                aHeight,
                (row, column) -> row >= column
        );
    }

    /**
     * Method draws the left side.
     *
     * @param aHeight Height.
     * @return String.
     */
    public final String leftTrl(final int aHeight) {
        return this.loopBy(
                aHeight,
                aHeight,
                (row, column) -> row >= aHeight - column - 1
        );
    }

    /**
     * Method draws pyramid.
     *
     * @param aHeight Height.
     * @return String.
     */
    public final String pyramid(final int aHeight) {
        return this.loopBy(
                aHeight,
                2 * aHeight - 1,
                (row, column) ->
                        row >= aHeight - column - 1
                                && row + aHeight - 1 >= column
        );
    }

    /**
     * Method checks where to set ^.
     *
     * @param aHeight  Height.
     * @param aWeight  Weight.
     * @param aPredict Predict.
     * @return String.
     */
    private String loopBy(
            final int aHeight,
            final int aWeight,
            final  BiPredicate<Integer, Integer> aPredict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != aHeight; row++) {
            for (int column = 0; column != aWeight; column++) {
                if (aPredict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
