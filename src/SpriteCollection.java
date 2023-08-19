import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * public class SpriteCollection.
 * this class handles collection of game sprites.
 */
public class SpriteCollection {

    private java.util.List<Sprite> sprites = new ArrayList<>();

    /**
     * public void addSprite(Sprite s).
     *
     * @param s sprite
     *          this method adds sprite to sprite collection
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);

    }

    /**
     * public void removeSprite(Sprite s).
     * @param s this method removes sprite from sprite collection
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * public void notifyAllTimePassed().
     * this method calls time passed method on all sprites which causes them to proceed in game.
     */
    public void notifyAllTimePassed() {
        for (Sprite s : new ArrayList<>(sprites)) {
            s.timePassed();
        }
    }

    /**
     * public void drawAllOn(DrawSurface d).
     * @param d draw surface
     * this method draws all sprites on draw surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : new ArrayList<>(sprites)) {
            s.drawOn(d);
        }
    }
}