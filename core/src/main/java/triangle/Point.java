package triangle;

/**
 * Class Point.
 * Implements simple point.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class Point {
    /**
     * X coordinate.
     */
    private int x;
    /**
     * Y coordinate.
     */
    private int y;

    /**
     * Constructor.
     *
     * @param aX Х.
     * @param aY Y.
     */
    public Point(final int aX, final int aY) {
        this.x = aX;
        this.y = aY;
    }

    /**
     * Method distanceTo calculates the distance between two points.
     *
     * @param aThat Point.
     * @return Distance.
     */
    public final double distanceTo(final Point aThat) {
        Point a = this;

        int x1 = a.x;
        int y1 = a.y;
        int x2 = aThat.x;
        int y2 = aThat.y;

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

    }
}
