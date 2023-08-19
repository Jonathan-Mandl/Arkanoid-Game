/** public class Velocity.
 * author Jonathan Mandl
 * this class stores velocity, applies velocity to a point and converts angle and speed to velocity
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * public Velocity(double dx, double dy).
     * @param dx of velocity
     * @param dy of velocity
     * this method is a constructor for velocity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * public double getDx().
     * @return dx of velocity
     * this method is an accessor for dx of velocity
     */
    public double getDx() {
        return dx;
    }
    /**
     * public double getDy().
     * @return dy of velocity
     * this method is an accessor for dy of velocity
     */
    public double getDy() {
        return dy;
    }

    /**
     * public static Velocity fromAngleAndSpeed(double angle, double speed).
     * @param angle of velocity
     * @param speed of velocity
     * @return velocity in dx,dy representation
     * this method converts angle and speed to velocity in dx,dy representation
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * -Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * public Point applyToPoint(Point p).
     * @param p point
     * @return new point with applied velocity
     * this method applies velocity to a point in space
     */
    public Point applyToPoint(Point p) {

        Point newPt = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPt;
    }
}