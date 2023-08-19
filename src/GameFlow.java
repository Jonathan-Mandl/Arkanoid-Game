
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * public class GameFlow.
 * this class handles the transition between the levels and the flow of the game.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;
    private boolean win;

    /**
     * public GameFlow(AnimationRunner ar, KeyboardSensor ks).
     *
     * @param ar animation runner
     * @param ks keyboard sensor
     *           constructor for class.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = new Counter(0);
        win = true;
    }

    /**
     * public void runLevels(List<> levels).
     *
     * @param levels this method handles transition between levels and win/loss in the game
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.ar, this.ks, this.score);

            level.initialize();

            level.run();


            if (level.getRemainingBalls().getValue() == 0) {
                win = false;
                break;
            }


        }
        if (win) {
            this.ar.run(new KeyPressStoppableAnimation(this.ks, "space",
                    new YouWinAnimation(this.score, this.ar.getGui())));
        } else {
            this.ar.run(new KeyPressStoppableAnimation(this.ks, "space",
                    new GameOverAnimation(this.score, this.ar.getGui())));
        }

        this.ar.getGui().close();
    }
}