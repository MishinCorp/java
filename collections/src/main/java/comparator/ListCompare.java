package comparator;

import java.util.Comparator;

/**
 * Class ListCompare.
 * Compares two Strings.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public final int compare(final String pLeft, final String pRight) {
        int result = 0;
        for (int i = 0; i < Math.min(pLeft.length(), pRight.length()); i++) {
            if (pLeft.codePointAt(i) != pRight.codePointAt(i)) {
                if ((pLeft.codePointAt(i) - pRight.codePointAt(i)) > 0) {
                    result = 1;
                } else {
                    result = -1;
                }
                break;
            }
        }
        if (result == 0) {
            result = pLeft.length() - pRight.length();
        }
        return result;
    }
}
