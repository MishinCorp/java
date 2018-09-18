package classicitemsearch;

/**
 * Class Converter.
 * Classic search.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.09.2018
 */
public class FindLoop {
    /**
     * Method searches an item.
     *
     * @param theDatas  Array.
     * @param anElement Element.
     * @return Index or -1.
     */
    public final int indexOf(final int[] theDatas, final int anElement) {
        int result = -1;

        for (int i = 0; i < theDatas.length; i++) {
            if (theDatas[i] == anElement) {
                result = i;
                break;
            }
        }

        return result;
    }
}
