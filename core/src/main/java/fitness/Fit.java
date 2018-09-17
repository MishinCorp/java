package fitness;

/**
 * Class Fit.
 * Calculates perfect weight.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 16.09.2018
 */
public class Fit {
    /**
     * ARG_ONE.
     */
    private static final double ARG_ONE = 1.15;
    /**
     * ARG_TWO.
     */
    private static final int ARG_TWO = 100;
    /**
     * ARG_THREE.
     */
    private static final int ARG_THREE = 110;
    /**
     * Perfect weight for a man.
     *
     * @param aHeight Height.
     * @return Perfect weight.
     */
    public final double manWeight(final double aHeight) {
        return (aHeight - ARG_TWO) * ARG_ONE;
    }

    /**
     * Perfect weight for a woman.
     *
     * @param aHeight Height.
     * @return Perfect weight.
     */
    public final double womanWeight(final double aHeight) {
        return (aHeight - ARG_THREE) * ARG_ONE;
    }
}
