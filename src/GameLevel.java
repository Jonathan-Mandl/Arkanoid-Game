import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 * public class Game.
 * this class handles game graphics and game objects such as shield, paddle, balls
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static int shieldSize;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter currentScore;
    private ScoreTrackingListener scoreListener;
    private ScoreIndicator scoreIndicator;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private boolean running;
    private LevelInformation level;

    /**
     * public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor keyboard, Counter currentScore).
     * @param level
     * @param runner
     * @param keyboard
     * @param currentScore
     * constructor for class
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor keyboard, Counter currentScore) {
        this.level = level;
        this.runner = runner;
        this.keyboard = keyboard;
        this.currentScore = currentScore;

    }

    /**
     * public void addCollidable(Collidable c).
     *
     * @param c collidable
     *          this method adds collidable to game environment.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * public void addSprite(Sprite s).
     *
     * @param s sprite
     *          this method adds sprite to sprite collection
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * public void gameShield().
     * this method creates game border which is composed of 4 rectangle blocks.
     */
    public void gameShield() {
        Block b1, b2, b3, b4;
        int size = this.shieldSize;
        Color c = Color.DARK_GRAY;

        b1 = new Block(new Rectangle(new Point(0, 30), WIDTH, size), c);
        b2 = new Block(new Rectangle(new Point(0, HEIGHT - size), WIDTH, size), c);
        b3 = new Block(new Rectangle(new Point(0, 0), size, HEIGHT), c);
        b4 = new Block(new Rectangle(new Point(WIDTH - size, 0), size, HEIGHT), c);
        b2.addHitListener(this.ballRemover);
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);

    }

    /**
     * public void gameBalls()
     * this method creates the balls in the game with speed, starting point color..
     */
    public void gameBalls() {
        Random rand = new Random();

        int numBalls = this.level.numberOfBalls();
        int r = 5;
        Color color = Color.WHITE;

        for (int i = 0; i < numBalls; i++) {

            Ball b = new Ball(new Point(WIDTH / 2, HEIGHT - 30 - r - getShieldSize()), r, color);
            b.setVelocity(level.initialBallVelocities().get(i));
            b.addToGame(this);

        }


    }

    /**
     * public void paddleGame().
     * this method creates the paddle of the game.
     */
    public void paddleGame() {

        int height = 30;
        Color color = Color.YELLOW;

        Paddle p =
                new Paddle(
                        new Rectangle(new Point((WIDTH - this.level.paddleWidth()) / 2, HEIGHT - height - shieldSize),
                                this.level.paddleWidth(), height),
                        color, this.keyboard, this.level.paddleSpeed());
        p.addToGame(this);

    }

    /**
     * public void gameBlocks().
     * this method creates game blocks arranged in lines with different colors
     */
    public void gameBlocks() {

        List<Block> blocks = this.level.blocks();

        for (Block b : blocks) {
            b.addHitListener(this.blockRemover);
            b.addHitListener(this.scoreListener);
            b.addToGame(this);
        }


    }

    /**
     * public static int getShieldSize().
     * this method is an accessor for shield size.
     *
     * @return shield size
     */
    public static int getShieldSize() {
        return shieldSize;
    }

    /**
     * public void initialize().
     * this method initializes game environment with new gui and calls the functions
     * such as gameShield and gameBlocks which create the objects in the game.
     */
    public void initialize() {

        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.shieldSize = 10;
        this.remainingBlocks = new Counter(this.level.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(level.numberOfBalls());
        this.blockRemover = new BlockRemover(this, this.remainingBlocks);
        this.ballRemover = new BallRemover(this, this.remainingBalls);
        this.scoreListener = new ScoreTrackingListener(this.currentScore);
        this.scoreIndicator = new ScoreIndicator(this.currentScore, this.level.levelName());


        Sprite background = this.level.getBackground();
        this.addSprite(background);
        this.addSprite(this.scoreIndicator);

        this.gameShield();
        this.gameBlocks();
        this.gameBalls();
        this.paddleGame();


    }

    /**
     * public void removeCollidable(Collidable c).
     *
     * @param c the collidable
     *          this method removed collidable from game environment/
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * public void removeSprite(Sprite s).
     *
     * @param s sprite
     *          this method removes sprite from sprite collection
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);

    }

    /**
     * public void run().
     * this method runs game
     */
    public void run() {

        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

    }

    /**
     * public GameEnvironment getEnvironment() .
     * this method is an accessor for game environment.
     *
     * @return game environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.drawAllOn(d);

        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new PauseScreen(this.keyboard)));
        }

        if (this.remainingBlocks.getValue() == 0) {
            this.currentScore.increase(100);
        }
        if (this.remainingBlocks.getValue() == 0) {
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * public Counter getRemainingBalls().
     * @return remaining balls counter
     * getter method for remaining balls counter
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     * public Counter getRemainingBlocks().
     * @return remaining blocks counter.
     * getter method for remaining blocks.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

}
