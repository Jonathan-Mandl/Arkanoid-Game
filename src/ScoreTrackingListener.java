/** public class ScoreTrackingListener implements HitListener.
 * this class is a listener type that keeps track of current score.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * public ScoreTrackingListener(Counter scoreCounter).
     * @param scoreCounter the counter
     * constructor for class
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
@Override
    public void hitEvent(Block beingHit, Ball hitter) {

        this.currentScore.increase(5);

    }

    /**
     * public Counter getCurrentScore().
     * @return current score counter
     * this method is a getter for current score
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }
}