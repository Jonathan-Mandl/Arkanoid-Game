/** class CollisionInfo.
 * this class holds collision point and collision object of the collision
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * public CollisionInfo(Point collisionPoint, Collidable collisionObject).
     * @param collisionPoint
     * @param collisionObject
     * this method is a constructor for the object
     */

    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     *  public Point collisionPoint().
     * @return collision point
     * this method is an accessor for collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * public Collidable collisionObject().
     * @return collision object
     * this method is an accessor for collison object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}