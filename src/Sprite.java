import biuoop.DrawSurface;

/**
 * public interface Sprite.
 * this interface handles sprite which is an object on the screen
 */
public interface Sprite {
    /**
     * void drawOn(DrawSurface d).
     * @param d DrawSurafce
     *this method draws sprite on drawsurface
     */
    void drawOn(DrawSurface d);

    /**
     * void timePassed().
     * this method determines the next move of the sprite in the game.
     */
    void timePassed();



}
