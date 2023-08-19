import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/** public class DirectHit implements LevelInformation.
 * this class hold information of DirectHit level.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        int num = 1;
        return num;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(0, 4));
        return v;
    }

    @Override
    public int paddleSpeed() {
        int speed = 7;
        return speed;
    }

    @Override
    public int paddleWidth() {
        int width = 100;
        return width;
    }

    @Override
    public String levelName() {
        String name = "Direct Hit";
        return name;
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background(Color.black);
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> b = new ArrayList<>();
        b.add(new Block(new Rectangle(new Point(GameLevel.WIDTH / 2, 200), 30, 30), Color.RED));
        return b;

    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
