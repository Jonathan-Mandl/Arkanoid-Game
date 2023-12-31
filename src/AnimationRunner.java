import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    public AnimationRunner(int framesPerSecond, GUI gui) {
        this.framesPerSecond=framesPerSecond;
        this.gui = gui;
    }

    Sleeper sleeper = new Sleeper();

    public void run(Animation animation) {
        int millisecondsPerFrame =1000/framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }

    }

    public GUI getGui() {
        return gui;
    }
}