import biuoop.DrawSurface;
import biuoop.GUI;

/**public class YouWinAnimation implements Animation.
 * this class handles you win screen.
 */
public class YouWinAnimation implements Animation {

    private boolean stop;
    private Counter finalScore;
    private GUI gui;

    /**
     * public YouWinAnimation(Counter finalScore, GUI gui).
     * @param finalScore
     * @param gui
     * constructor method
     */
    public YouWinAnimation(Counter finalScore, GUI gui) {
        this.stop = false;
        this.finalScore = finalScore;
        this.gui = gui;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win!. Your score is: " + this.finalScore.getValue(), 32);
    }
@Override
    public boolean shouldStop() {
        return this.stop;
    }
}


