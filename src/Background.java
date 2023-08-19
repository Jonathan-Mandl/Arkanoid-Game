import biuoop.DrawSurface;

import java.awt.Color;

/**public class Background implements Sprite.
 * this class handles background of screen.
 */
public class Background implements Sprite {
    private Color color;
    private Block background;

    /**
     * public Background(Color color).
     * constructor for class
     * @param color
     */
    public Background(Color color) {
        this.color = color;
        this.background = new Block(new Rectangle(new Point(0, 0), GameLevel.WIDTH, GameLevel.HEIGHT), this.color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.background.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}
