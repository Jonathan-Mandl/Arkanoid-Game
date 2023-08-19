import biuoop.DrawSurface;

/** public interface Animation.
 * this interface handles animation function
 */
public interface Animation {
    /**
     * void doOneFrame(DrawSurface d).
     * @param d the Drawsurface
     * this method contain information about what the animation can do on given frame.
     */
    void doOneFrame(DrawSurface d);

    /**
     * boolean shouldStop().
     * @return boolean if animation should stop
     * this method tell animation if it should stop
     */
    boolean shouldStop();
}