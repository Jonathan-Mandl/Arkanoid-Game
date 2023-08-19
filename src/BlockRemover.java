/** public class BlockRemover implements HitListener.
 * this class is a listener type that removes blocks when they are hit by the ball.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * public BlockRemover(Game game, Counter removedBlocks).
     * @param game the game
     * @param removedBlocks the counter
     * this method is a constructor
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);

    }
}