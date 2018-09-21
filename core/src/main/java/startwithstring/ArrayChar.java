package startwithstring;

/**
 * Class ArrayChar.
 * Checks if the line starts with the prefix or not.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 20.09.2018
 */
public class ArrayChar {
    /**
     * Characters array.
     */
    private char[] data;

    /**
     * Constructor.
     *
     * @param aLine Line.
     */
    public ArrayChar(final String aLine) {
        this.data = aLine.toCharArray();
    }

    /**
     * Method checks that the line starts with the prefix.
     *
     * @param aPrefix Prefix.
     * @return Boolean.
     */
    public final boolean startWith(final String aPrefix) {
        boolean result = true;
        char[] value = aPrefix.toCharArray();

        for (int i = 0; i < value.length; i++) {
            if (value[i] != this.data[i]) {
                result = false;
                break;
            }
        }

        return result;
    }
}

