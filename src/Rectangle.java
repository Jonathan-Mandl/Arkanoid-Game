import java.util.ArrayList;

/**
 * public class Rectangle .
 * this class handles the rectangles in the game like block, paddle
 */
public class Rectangle {
    private Point upperleft;
    private double width;
    private double height;

    private Line top;
    private Line bottom;
    private Line left;
    private Line right;


    /**
     * public Rectangle(Point upperLeft, double width, double height).
     * @param upperLeft
     * @param width
     * @param height    the method is a constructor for object rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperleft = upperLeft;
        this.width = width;
        this.height = height;


        this.top = new Line(upperleft.getX(), upperleft.getY(), upperleft.getX() + this.width, upperleft.getY());
        this.bottom = new Line(upperleft.getX(), upperleft.getY() + this.height, upperleft.getX() + this.width,
                upperleft.getY() + this.height);
        this.left = new Line(upperleft.getX(), upperleft.getY(), upperleft.getX(), upperleft.getY() + this.height);
        this.right = new Line(upperleft.getX() + this.width, upperleft.getY(), upperleft.getX() + this.width,
                upperleft.getY() + this.height);
    }

    /**
     * public java.util.List<> intersectionPoints(Line line).
     * @param line
     * @return intersection points of rectangle with line
     * this method finds all intersection points of the rectangle with a given line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        java.util.List<Point> intersections = new ArrayList<Point>();

        if (top.isIntersecting(line)) {
            intersections.add(top.intersectionWith(line));
        }
        if (bottom.isIntersecting(line)) {
            intersections.add(bottom.intersectionWith(line));
        }
        if (right.isIntersecting(line)) {
            intersections.add(right.intersectionWith(line));
        }
        if (left.isIntersecting(line)) {
            intersections.add(left.intersectionWith(line));
        }

        return intersections;

    }

    /**
     * public Line getBottom().
     * @return bottom line of rectangle
     * this method is an accessor for line of bottom side of rectangle
     */
    public Line getBottom() {
        return this.bottom;
    }
    /**
     * public Line getTop().
     * @return top line of rectangle
     * this method is an accessor for line of top side of rectangle
     */
    public Line getTop() {
        return top;
    }
    /**
     * public Line getLeft().
     * @return left side of rectangle
     * this method is an accessor for line of left side of rectangle
     */
    public Line getLeft() {
        return left;
    }
    /**
     * public Line getRight().
     * @return right side of rectangle
     * this method is an accessor for line of right side of rectangle
     */
    public Line getRight() {
        return right;
    }

    /**
     * public double getWidth().
     * @return width of rectangle
     * this method is an accessor for width of rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * public double getHeight() .
     * @return height of rectangle
     * this method is an accessor for height of rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * public Point getUpperLeft() .
     * @return upper left vertex of rectangle
     * this method is an accessor for upper left point of rectangle.
     */
    public Point getUpperLeft() {
        return this.upperleft;
    }
}