import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * public class GameOver implements Animation.
 * this class handles the game over screen.
 */
public class GameOverAnimation implements Animation {

    private boolean stop;
    private Counter finalScore;
    private GUI gui;

    /**
     * public GameOver(Counter finalScore, GUI gui).
     * @param finalScore
     * @param gui
     * constructor method for class.
     */
    public GameOverAnimation(Counter finalScore, GUI gui) {
        this.stop = false;
        this.finalScore = finalScore;
        this.gui = gui;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your Score is: " + this.finalScore.getValue(), 32);

    }
@Override
    public boolean shouldStop() {
        return this.stop;
    }
}


