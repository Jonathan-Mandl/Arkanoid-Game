import java.util.ArrayList;

/**
 * public class GameEnvironment.
 * this class handles collection of collidable objects
 * and can get the closest collision in trajectory of object like ball.
 */
public class GameEnvironment {

    private java.util.List<Collidable> collidables = new ArrayList<>();

    /**
     * public void addCollidable(Collidable c).
     * @param c collidable
     * this method can add a collidable object to list of collidables.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * public void removeCollidable(Collidable c).
     * @param c the collidable
     * this method removed collidable from game environment
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * public CollisionInfo getClosestCollision(Line trajectory).
     * @param trajectory the trajectory of object
     * @return colosest collision point
     * this method returns information about the closest collision in the trajectory of moving object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo closest = null;
        double minDistance = trajectory.length();

        for (Collidable c : new ArrayList<>(this.collidables)) {
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (p == null) {
                continue;
            }
            double distance = p.distance(trajectory.start());
            if (distance < minDistance) {
                minDistance = distance;
                closest = new CollisionInfo(p, c);

            }
        }
        return closest;

    }

}
