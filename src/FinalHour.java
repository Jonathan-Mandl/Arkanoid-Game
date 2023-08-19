import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**public class FinalHour implements LevelInformation.
 * this class handles level FinalHour information
 */
public class FinalHour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int angle = 315 + 45 * i;
            v.add(Velocity.fromAngleAndSpeed(angle, 4));
        }
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return new String("Final Hour");
    }

    @Override
    public Sprite getBackground() {
        return new Background(new Color(51, 153, 255));
    }

    @Override
    public List<Block> blocks() {
        int width = 52;
        int height = 25;
        Color[] colors =
                new Color[] {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, new Color(255, 153, 153),
                        new Color(51, 255, 255)};

        List<Block> blocks = new ArrayList<Block>();

        for (int i = 0; i < 7; i++) {

            Color color = colors[i];
            for (int j = 1; j <= 15; j++) {
                double x = GameLevel.WIDTH - 10 - j * width;
                double y = 150 + (height + 1) * i;
                Point p = new Point(x, y);
                Block b = new Block(new Rectangle(p, width, height), color);
                blocks.add(b);

            }

        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
