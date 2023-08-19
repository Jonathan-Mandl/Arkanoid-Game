import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * public class Block implements Collidable,Sprite.
 * this class handles the blocks of the game
 * implements classes Collidable and Sprite
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;

    private Color color;

    private List<HitListener> hitListeners;


    /**
     * public Block(Rectangle rect, Color color).
     *
     * @param rect  the rectangle of block
     * @param color the color of block
     *              this method is a constructor for object block
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        this.notifyHit(hitter);

        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (this.rect.getTop().containsPoint(collisionPoint) || this.rect.getBottom().containsPoint(collisionPoint)) {
            dy *= -1;
        }
        // in this case the collision is in left/right border.
        if (this.rect.getLeft().containsPoint(collisionPoint) || this.rect.getRight().containsPoint(collisionPoint)) {
            dx *= -1;
        }
        return new Velocity(dx, dy);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
    /**
     * private void notifyHit(Ball hitter).
     * @param hitter the ball
     *  this method notifies all hit listeners of block when a ball hits.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * public void removeFromGame(Game game).
     *
     * @param game this method removes block from game when  it is hit by a ball.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
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
    public void timePassed() {

    }

    /**
     * public void addToGame(Game g).
     *
     * @param g game
     *          this method adds block to sprite collection and game environment of game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
