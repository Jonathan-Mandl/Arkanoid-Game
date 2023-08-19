/**
 * public class Point.
 * @author Jonathan Mandl
 * this class calculates distance from other points and if two points are equal and stores point.
 */
public class Point {
    private double x;
    private double y;
    // constructor

    /**
     * public Point(double x, double y).
     *
     * @param x the input
     * @param y the input
     *   this method is a constructor for point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * public double distance(Point other).
     *
     * @param other point the input
     * @return distance from other point
     * this method calculates distance from other point
     */
    public double distance(Point other) {
        double x1 = this.x;
        double y1 = this.y;
        double y2 = other.getY();
        double x2 = other.getX();
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance;

    }

    /**
     * public boolean equals(Point other).
     *
     * @param other point the input
     * @return boolean if 2 points are equal
     * this method finds out if the point is equal to another point are returns true/false
     */
    public boolean equals(Point other) {
        return other.getX() == this.x && other.getY() == this.y;
    }

    /**
     * public double getX().
     *
     * @return x
     * this method is a getter for x
     */
    public double getX() {
        return this.x;
    }

    /**
     * public double getY().
     *
     * @return y
     * this method is a getter for y
     */
    public double getY() {
        return this.y;
    }


}

