package convert;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Person.
 * Implements entity Person.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.09.2018
 */
public class ConvertList {
    /**
     * Method converts the 2D-array into a list.
     *
     * @param anArray 2D-array.
     * @return List.
     */
    public final List<Integer> toList(final int[][] anArray) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : anArray) {
            for (int item : i) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Method converts the list into a 2D-array.
     *
     * @param aList   List.
     * @param theRows Rows number.
     * @return 2D-array.
     */
    public final int[][] toArray(final List<Integer> aList, final int theRows) {
        int cols;
        if (aList.size() % theRows != 0) {
            cols = (aList.size() / theRows);
            cols++;
        } else {
            cols = aList.size() / theRows;
        }
        int[][] result = new int[theRows][cols];
        int count = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (count < aList.size()) {
                    result[i][j] = aList.get(count);
                }
                count++;
            }
        }
        return result;
    }

    /**
     * Method creates a merged list.
     *
     * @param theList List<int[].
     * @return List List<Integer>.
     */
    public final List<Integer> convert(final List<int[]> theList) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : theList) {
            for (int item : i) {
                result.add(item);
            }
        }
        return result;
    }
}
