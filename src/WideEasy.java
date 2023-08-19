import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**public class WideEasy implements LevelInformation.
 * this class handles WideEasy level information.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (i == 6) {
                continue;
            }
            int angle = 275 + 17 * i;
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
        return 500;
    }

    @Override
    public String levelName() {
        return new String("Wide Easy");
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.WHITE);
    }

    @Override
    public List<Block> blocks() {
        Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK,
                Color.LIGHT_GRAY};
        List<Block> blocks = new ArrayList<Block>();

        for (int i = 0; i < 7; i++) {

            Color color = colors[i];
            for (int j = 0; j < 2; j++) {
                Point p = new Point(10 + 55 * 2 * i + 55 * j, 200);
                Block b = new Block(new Rectangle(p, 55, 20), color);
                blocks.add(b);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 14;
    }
}
