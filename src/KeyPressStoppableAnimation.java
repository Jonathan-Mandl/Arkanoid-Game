import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * public class KeyPressStoppableAnimation implements Animation .
 * this class is a decorator class handling key stoppable functionality of animation
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation).
     * @param sensor
     * @param key
     * @param animation
     * constructor method for class
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}