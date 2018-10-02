package convert;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertListTest.
 * Tests ConvertList class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.09.2018
 */
public class ConvertListTest {
    private final ConvertList convertList = new ConvertList();

    /**
     * Tests toList method.
     */
    @Test
    public void whenAddArrayThenResultList() {
        int[][] array = {{1, 2, 3}, {4, 5}, {6, 7}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = convertList.toList(array);

        assertThat(result, is(expected));
    }

    /**
     * Tests toArray method.
     */
    @Test
    public void whenAddListThenResultArrayRowsThree() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] result = convertList.toArray(list, 3);

        assertThat(result, is(expected));
    }

    /**
     * Tests toArray method.
     */
    @Test
    public void whenAddListThenResultArrayRowsTwo() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}};
        int[][] result = convertList.toArray(list, 2);

        assertThat(result, is(expected));
    }

    /**
     * Тест метода convert.
     */
    @Test
    public void whenConvertThanResultList() {
        List<int[]> list = Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = convertList.convert(list);

        assertThat(result, is(expected));
    }
}
