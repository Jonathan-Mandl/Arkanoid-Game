import java.util.List;

/**
 * public interface LevelInformation.
 * this interface holds information on each level.
 */
public interface LevelInformation {
    /**
     * int numberOfBalls().
     * @return number of balls
     * this method gets numbers of balls on level.
     */
    int numberOfBalls();

    /**
     * List<> initialBallVelocities().
     * @return initial ball velocities list
     * this method gets a list of ball velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * int paddleSpeed().
     * @return paddle speed
     * this method gets paddle speed on level.
     */
    int paddleSpeed();

    /**
     * int paddleWidth().
     * @return paddle width
     * this method gets paddle width on level
     */
    int paddleWidth();

    /**
     * String levelName().
     * this method gets level name.
     * @return level name
     */
    String levelName();

    /**
     * Sprite getBackground().
     * @return background
     * this method gets background of level.
     */
    Sprite getBackground();

    /**
     * List<> blocks().
     * @return blocks list
     * this method gets a list of blocks on the level.
     */
    List<Block> blocks();

    /**
     * int numberOfBlocksToRemove().
     * @return number of blocks to remove
     * this method returns the number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}