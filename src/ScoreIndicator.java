import biuoop.DrawSurface;


import java.awt.Color;

/**
 * public class ScoreIndicator implements Sprite.
 * this class handles the score indicator in the top of the screen.
 */
public class ScoreIndicator implements Sprite {

    private Rectangle rect = new Rectangle(new Point(0, 0), GameLevel.WIDTH, 30);
    private Color color = Color.lightGray;
    private Block block = new Block(this.rect, this.color);
    private Counter currentScore;
    private String level;

    /**
     * public ScoreIndicator(Counter currentScore).
     * @param level
     * @param currentScore the counter
     *  this method is a constructor for class
     */
    public ScoreIndicator(Counter currentScore, String level) {
        this.currentScore = currentScore;
        this.level = level;
    }

    @Override
    public void drawOn(DrawSurface d) {
        block.drawOn(d);
        d.setColor(Color.black);
        d.drawText(GameLevel.WIDTH / 2, 20, "Score: " + this.currentScore.getValue(), 17);
        d.drawText(600, 20, "Level Name: " + this.level, 17);
    }

    @Override
    public void timePassed() {

    }
}
