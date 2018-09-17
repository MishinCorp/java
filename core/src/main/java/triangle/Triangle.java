package triangle;

/**
 * Class Triangle.
 * Implements triangle area calculation.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.09.2018
 */
public class Triangle {
    /**
     * Point a.
     */
    private Point a;
    /**
     * Point b.
     */
    private Point b;
    /**
     * Point c.
     */
    private Point c;

    /**
     * Constructor.
     *
     * @param anA А.
     * @param aB B.
     * @param aC C.
     */
    public Triangle(final Point anA, final Point aB, final Point aC) {
        this.a = anA;
        this.b = aB;
        this.c = aC;
    }

    /**
     * Method calculates semiperimetr.
     * <p>
     * Formula.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab Distance A B.
     * @param ac Distance A C.
     * @param bc Distance B C.
     * @return Semiperimetr.
     */
    public final double period(
            final double ab,
            final double ac,
            final double bc) {

        return (ab + ac + bc) / 2;
    }

    /**
     * Method calculates triangle area.
     *
     * @return Area. Or -1 if n/a.
     */
    public final double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);

        if (this.exist(ab, ac, bc)) {

            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Method checks if the triangle exists.
     *
     * @param ab Distance ab.
     * @param ac Distance ac.
     * @param bc Distance bc.
     * @return Boolean.
     */
    private boolean exist(
            final double ab,
            final  double ac,
            final  double bc) {

        return (ab + bc > ac) && (ab + ac > bc) && (ac + bc > ab);
    }
}
