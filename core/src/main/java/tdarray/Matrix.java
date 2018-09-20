package tdarray;

/**
 * Class Matrix.
 * Builds a multiplication table.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.09.2018
 */
public class Matrix {
    /**
     * Method builds a multiplication table.
     *
     * @param aSize Size.
     * @return two dimensional array int[][].
     */
    public final int[][] multiple(final int aSize) {
        int[][] matrix = new int[aSize][aSize];

        for (int i = 0; i < aSize; i++) {
            for (int j = 0; j < aSize; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }

        return matrix;
    }
}
