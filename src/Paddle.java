import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class Paddle implements Sprite, Collidable.
 * this class handles paddle in the game and implements classes Sprite and Collidable.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private Color color;
    private int speed;

    /**
     * public Paddle(Rectangle rect, Color color, biuoop.KeyboardSensor keyboard, int speed) .
     * @param rect rectangle
     * @param color
     * @param keyboard keyboard sensor of gui
     * @param speed
     * this method is a constructor for object paddle
     */
    public Paddle(Rectangle rect, Color color, biuoop.KeyboardSensor keyboard, int speed) {
        this.rect = rect;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    /**
     * public void moveLeft().
     * this method moves paddle left
     */
    public void moveLeft() {
        double x = Math.max(GameLevel.getShieldSize(), this.rect.getUpperLeft().getX() - speed);

        this.rect = new Rectangle(new Point(x, this.rect.getUpperLeft().getY()), this.rect.getWidth(),
                this.rect.getHeight());

    }

    /**
     * public void moveRight().
     *  this method moves paddle right.
     */
    public void moveRight() {
        double x = Math.min(GameLevel.WIDTH - GameLevel.getShieldSize() - this.rect.getWidth(),
                this.rect.getUpperLeft().getX() + speed);

        this.rect = new Rectangle(new Point(x, this.rect.getUpperLeft().getY()), this.rect.getWidth(),
                this.rect.getHeight());
    }

 @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            this.moveRight();
        }

    }

   @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());

    }

  @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (this.rect.getTop().containsPoint(collisionPoint)) {

            return coolPaddle(collisionPoint, this.rect.getTop(), dx, dy);

        }


        if (this.rect.getBottom().containsPoint(collisionPoint)) {
            dy *= -1;
        }
        // in this case the collision is in left/right border.
        if (this.rect.getLeft().containsPoint(collisionPoint) || this.rect.getRight().containsPoint(collisionPoint)) {
            dx *= -1;
        }

        return new Velocity(dx, dy);


    }

    /**
     * private Velocity coolPaddle(Point collisionPoint, Line top, double dx, double dy).
     * @param collisionPoint
     * @param top top line of rectangle
     * @param dx of velocity
     * @param dy of velocity
     * @return new velocity
     * this method return new velocity of ball after it hit top of paddle based on the region of the paddle the ball hit
     */
    private Velocity coolPaddle(Point collisionPoint, Line top, double dx, double dy) {

        int region = this.findCollisionRegion(collisionPoint, top);
        if (region == 3) {
            return new Velocity(dx, -dy);
        }
        int angle = (region * 30 + 270) % 360;
        double speed = Math.sqrt(dx * dx + dy * dy);
        return Velocity.fromAngleAndSpeed(angle, speed);


    }

    /**
     * private int findCollisionRegion(Point collisionPoint, Line top).
     * @param collisionPoint of ball
     * @param top top line of rectangle
     * @return collision region on top of paddle
     * this method returns the region where the ball hit the paddle.
     */
    private int findCollisionRegion(Point collisionPoint, Line top) {

        double xPoint = collisionPoint.getX();
        double part = top.length() / 5;
        double xStart = this.rect.getUpperLeft().getX();
        for (int i = 1; i < 5; i++) {
            if (xPoint < xStart + part * i) {
                return i;
            }
        }
        return 5;

    }


    /**
     * public void addToGame(Game g).
     * this method adds paddle to sprite collection and game environemnt of the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}