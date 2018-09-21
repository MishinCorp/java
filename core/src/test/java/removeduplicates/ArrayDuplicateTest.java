package removeduplicates;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayDuplicateTest.
 * Tests ArrayDuplicate class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 21.09.2018
 */
public class ArrayDuplicateTest {
    /**
     * Tests method remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();

        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};
        String[] result = arrayDuplicate.remove(input);

        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}
