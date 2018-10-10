package convert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class ConvertList.
 * Implements conversion methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.09.2018
 */
public class ConvertList {
    /**
     * Method converts the 2D-array into a list.
     *
     * @param pArray 2D-array.
     * @return List.
     */
    public final List<Integer> toList(final int[][] pArray) {
        return Arrays.stream(pArray)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
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
        return theList.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
