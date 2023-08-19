import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Green3 implements LevelInformation.
 * this class hold information of level Green3
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();

        v.add(Velocity.fromAngleAndSpeed(45, 4));
        v.add(Velocity.fromAngleAndSpeed(315, 4));

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
        return new String("Green 3");
    }

    @Override
    public Sprite getBackground() {
        return new Background(new Color(0, 153, 0));
    }

    @Override
    public List<Block> blocks() {
        int width = 50;
        int height = 25;
        Color[] colors = new Color[] {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};

        List<Block> blocks = new ArrayList<Block>();

        for (int i = 0; i < 5; i++) {

            Color color = colors[i];
            for (int j = 1; j < 11 - i; j++) {
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
        return 40;
    }
}
