/**
 * public interface HitListener.
 * this interface handles hitlistener whhich keep track of when blocks are hit in the game.
 */
public interface HitListener {


    /**
     * void hitEvent(Block beingHit, Ball hitter).
     * @param beingHit the block that it getting hit
     * @param hitter   the ball that hits
     *   This method is called whenever the beingHit object is hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}