package pseudographics;

/**
 * Class Board.
 * Builds chessboard.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class Board {
    /**
     * Method builds chessboard.
     *
     * @param aWidth  Width.
     * @param aHeight - Height.
     * @return String.
     */
    public final String paint(final int aWidth, final int aHeight) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < aHeight; i++) {
            for (int j = 0; j < aWidth; j++) {

                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }

        return screen.toString();
    }
}
