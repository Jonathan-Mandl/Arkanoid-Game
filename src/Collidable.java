/**public interface Collidable.
 * this interface has functions that get rectangle of a collidable object such as block or paddle
 * and return new velocity of ball after it hits a collidable object.
 */

public interface Collidable {
    /**
     * Rectangle getCollisionRectangle().
     * @return rectangle of collidable object
     * this function returns the rectangle of a collidable object such as block or paddle
     */
    Rectangle getCollisionRectangle();

    /**
     * Velocity hit(Point collisionPoint, Velocity currentVelocity).
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return new velocity
     * this method returns the new velocity of ball after it hits a collidable object
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}