package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator.
 * Implements iterator for a two dimensional array.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 16.10.2018
 */
public class MatrixIterator implements Iterator {
    /**
     * Values.
     */
    private final int[][] values;
    /**
     * Colums.
     */
    private int col = 0;
    /**
     * Rows.
     */
    private int row = 0;

    /**
     * Constructor.
     *
     * @param pValues Two dimensional array.
     */
    public MatrixIterator(final int[][] pValues) {
        this.values = pValues;
    }

    @Override
    public final boolean hasNext() {
        boolean result = false;
        int colLength = this.values.length;
        if (this.col < colLength) {
            int rowLength = this.values[this.col].length;
            if ((this.col < colLength) && (this.row < rowLength)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public final Object next() {
        Object result = null;
        int colLength = this.values.length;
        if (this.col < colLength) {
            int rowLength = this.values[this.col].length;
            if (this.row < rowLength) {
                result = values[this.col][this.row++];
            }
            if (this.row == rowLength) {
                this.row = 0;
                this.col++;
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
