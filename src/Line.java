/**
 * public class Line.
 *
 * @author Jonathan Mandl
 * this class stores line, finds length of line, find intersector of
 * line with other lines and checks if line is equal to another line
 */

public class Line {
    private Point start;
    private Point end;

    /**
     * public Line(Point start, Point end).
     *
     * @param start of line
     * @param end   of line
     *              this method is a constructor for line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * public Line(double x1, double y1, double x2, double y2).
     *
     * @param x1 of line
     * @param y1 of line
     * @param x2 of line
     * @param y2 of line
     *           this method is a constructor for line based of coordinates of edges of line
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * public double max(double a, double b).
     *
     * @param a
     * @param b
     * @return max
     * this method find maximum of two numbers
     */
    public double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * public double min(double a, double b).
     *
     * @param a
     * @param b
     * @return min
     * this method find minimum of two numbers
     */
    public double min(double a, double b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }


    /**
     * public double length().
     *
     * @return length
     * this method calculates length of line
     */
    public double length() {
        double x1 = start.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double x2 = end.getX();
        double length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return length;
    }

    /**
     * public Point middle().
     *
     * @return middle
     * this method returns middle of line
     */
    public Point middle() {
        double x1 = start.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double x2 = end.getX();
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;
        Point middle = new Point(midX, midY);
        return middle;
    }

    /**
     * public Point start().
     *
     * @return start point
     * this method is an accessor for start point of line
     */
    public Point start() {
        return this.start;
    }

    /**
     * public Point end().
     *
     * @return end point
     * this method is an accessor for end point of line
     */
    public Point end() {
        return this.end;
    }

    /**
     * public boolean isIntersecting(Line other).
     *
     * @param other
     * @return bool
     * this method return true if line intersects with other line, false otherwise
     */
    public boolean isIntersecting(Line other) {

        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double x2 = this.end.getX();

        Point start = other.start();
        Point end = other.end();

        double p1 = start.getX();
        double q1 = start.getY();
        double p2 = end.getX();
        double q2 = end.getY();


        double a1 = y2 - y1;
        double b1 = x1 - x2;
        double c1 = a1 * x1 + b1 * y1;
        double a2 = q2 - q1;
        double b2 = p1 - p2;
        double c2 = a2 * p1 + b2 * q1;


        double determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return this.containsPoint(other.start) || this.containsPoint(other.end);
        } else {
            double xIntersect = (b2 * c1 - b1 * c2) / determinant;
            double yIntersect = (a1 * c2 - a2 * c1) / determinant;
            Point inter = new Point(xIntersect, yIntersect);
            return this.containsPoint(inter) && other.containsPoint(inter);
        }
    }

    /**
     * public boolean containsPoint(Point p).
     *
     * @param p point
     * @return bollean
     * this method return true if line conatains point, false otherwise
     */

    public boolean containsPoint(Point p) {
        double epsilon = 10E-9;
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double x2 = this.end.getX();

        return p.getX() <= max(x1, x2) + epsilon && p.getX() >= min(x1, x2) - epsilon
                && p.getY() <= max(y1, y2) + epsilon && p.getY() >= min(y1, y2) - epsilon;
    }

    /**
     * public Point intersectionWith(Line other).
     *
     * @param other line
     * @return intersection with other line
     * this method return point of intersection with other line or null if lines don't intersect
     */
    public Point intersectionWith(Line other) {

        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double x2 = this.end.getX();

        Point start = other.start();
        Point end = other.end();

        double p1 = start.getX();
        double q1 = start.getY();
        double p2 = end.getX();
        double q2 = end.getY();


        double a1 = y2 - y1;
        double b1 = x1 - x2;
        double c1 = a1 * x1 + b1 * y1;
        double a2 = q2 - q1;
        double b2 = p1 - p2;
        double c2 = a2 * p1 + b2 * q1;

        double determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return null;
        } else {
            double xIntersect = (b2 * c1 - b1 * c2) / determinant;
            double yIntersect = (a1 * c2 - a2 * c1) / determinant;
            Point inter = new Point(xIntersect, yIntersect);
            if (this.containsPoint(inter) && other.containsPoint(inter)) {
                return inter;
            } else {
                return null;
            }
        }

    }


    /**
     * public boolean equals(Line other).
     *
     * @param other line
     * @return true if lines are equal, false otherwise
     * this method return true if lines of are equal, false otherwise
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) || this.start.equals(other.end) && (this.end.equals(other.start)
                || this.end.equals(other.end));
    }

    /**
     * public Point closestIntersectionToStartOfLine(Rectangle rect).
     * @param rect the rectangle
     * @return closest intersection to the start of the line.
     * this method returns the closest intersection between the rectangle to the start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersections = rect.intersectionPoints(this);

        Point closest = null;
        double minDistance = this.length();
        for (Point p : intersections) {
            if (p == null) {
                continue;
            }
            double distance = p.distance(this.start);
            if (distance <= minDistance) {
                minDistance = distance;
                closest = p;
            }

        }
        return closest;

    }

}