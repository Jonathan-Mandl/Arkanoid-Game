import biuoop.DrawSurface;

import java.awt.Color;


/**
 * public class Ball.
 *
 * @author Jonathan Mandl
 * this class stores ball, draws ball, sets ball velocity and moves ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;

    private GameEnvironment ge;


    /**
     * public Ball(Point center, int r, java.awt.Color color).
     *
     * @param center center of ball
     * @param r      radius of ball
     * @param color  color of ball
     *               this method is a constructor for object ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * public Ball(int x, int y, int r, java.awt.Color color).
     *
     * @param x     x coordinate of center
     * @param y     y coordinate of center
     * @param r     radius of ball
     * @param color color of ball
     *              this method is a constructor for object ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        Point center = new Point(x, y);
        this.center = center;
        this.r = r;
        this.color = color;

    }

    /**
     * public int getX().
     *
     * @return x coordinate of center
     * this method is an accessor for x coordinate of center of ball
     */
    public int getX() {
        return (int) this.center.getX();

    }

    /**
     * public int getY().
     *
     * @return y coordinate of center
     * this method is an accessor for y coordinate of center of ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * public int getSize().
     *
     * @return radius of ball
     * this method is an accessor for radius of ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * public java.awt.Color getColor().
     *
     * @return color of ball
     * this method is an accessor for color of ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * public void setVelocity(Velocity v).
     *
     * @param v velocity
     *          this method is a setter for ball velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * public void setVelocity(double dx, double dy).
     *
     * @param dx of velocity of ball
     * @param dy of velocity of ball
     *           this method is a setter for ball velocity
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * public Velocity getVelocity().
     *
     * @return velocity of ball
     * this method is an accessor for velocity of ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * public void addToGame(Game g).
     *
     * @param g game
     *          this method adds ball to the current game and sets the gameEnvironment of ball.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.ge = g.getEnvironment();

    }


    /**
     * public void moveOneStep().
     * this method moves ball based on its velocity
     */
    public void moveOneStep() {
        if (ge == null) {
            this.center = this.velocity.applyToPoint(this.center);
            return;
        }
        Line tragectory = new Line(this.center, this.velocity.applyToPoint(this.center));

        CollisionInfo collision = this.ge.getClosestCollision(tragectory);

        if (collision == null) {
            this.center = this.velocity.applyToPoint(this.center);
            return;
        }

        this.velocity = collision.collisionObject().hit(this, collision.collisionPoint(), this.velocity);
        Point collisionPoint = collision.collisionPoint();
        double addX = 0;
        double addY = 0;
        if (this.velocity.getDx() > 0) {
            addX = 10e-3;
        } else if (this.velocity.getDx() < 0) {
            addX = -10e-3;
        }
        if (this.velocity.getDy() > 0) {
            addY = 10e-3;
        } else if (this.velocity.getDy() < 0) {
            addY = -10e-3;
        }
        this.center = new Point(collisionPoint.getX() + addX, collisionPoint.getY() + addY);

    }

    /**
     * public void setGe(GameEnvironment ge).
     *
     * @param ge GameEnvironment
     *           this method sets the game environment of ball
     */
    public void setGe(GameEnvironment ge) {
        this.ge = ge;
    }

    /**
     * public void removeFromGame(Game g).
     *
     * @param g the game
     *          this method removes ball from game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}