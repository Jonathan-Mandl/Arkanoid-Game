/**
 * public interface HitNotifier.
 * this interface can notify objects - listners- in the game when they are hit
 */
public interface HitNotifier {

    /**
     * void addHitListener(HitListener hl).
     * @param hl hitlistener
     * this method adds hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     * void removeHitListener(HitListener hl).
     * @param hl hitlistener
     * this method removes hl as a listener to hit events.
     */
    void removeHitListener(HitListener hl);
}