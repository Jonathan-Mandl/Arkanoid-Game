/**
 * public class BallRemover implements HitListener.
 * this method removed ball from game when it hits the game over block.
 */
public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * public BallRemover(Game game, Counter remainingBalls).
     * @param game the game
     * @param remainingBalls counter
     * this method is a constructor for class.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        remainingBalls.decrease(1);

        hitter.removeFromGame(this.game);
    }

}
