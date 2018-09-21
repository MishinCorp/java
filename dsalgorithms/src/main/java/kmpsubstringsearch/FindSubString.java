package kmpsubstringsearch;

/**
 * Class FindSubString.
 * Implements Knuth–Morris–Pratt algorithm.
 * Search substring in the string.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 21.09.2018
 */
public class FindSubString {
    /**
     * Method checks that the string contains the substring.
     *
     * @param anOrigin String.
     * @param aSub     Substring.
     * @return Boolean.
     */
    public final boolean contains(final String anOrigin, final String aSub) {
        char[] haystack = anOrigin.toCharArray();
        char[] needle = aSub.toCharArray();

        boolean result = false;

        for (int i = 0; i < (haystack.length - needle.length + 1); i++) {
            boolean success = true;

            for (int j = 0; j < needle.length; j++) {
                if (needle[j] != haystack[i + j]) {
                    success = false;
                    break;
                }
            }
            if (success) {
                result = true;
                break;
            }
        }

        return result;
    }
}
