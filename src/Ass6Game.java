//id: 211399175

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * public class Ass3Game.
 * this class creates game object, initializes it and runs it.
 */
public class Ass6Game {

    /**
     * public static void main(String[] args).
     *
     * @param args
     */
    public static void main(String[] args) {
        GUI gui = new GUI("game", GameLevel.WIDTH, GameLevel.HEIGHT);
        AnimationRunner ar = new AnimationRunner(60, gui);

        List<LevelInformation> levels = new ArrayList<>();

        if (args[0].equals("${args}")) {

            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalHour());
        } else {
            for (String i : args) {
                switch (i) {
                    case "1":
                        levels.add(new DirectHit());
                        break;
                    case "2":
                        levels.add(new WideEasy());
                        break;
                    case "3":
                        levels.add(new Green3());
                        break;
                    case "4":
                        levels.add(new FinalHour());
                        break;
                    default:
                        break;
                }
            }
        }

        GameFlow gameFlow = new GameFlow(ar, gui.getKeyboardSensor());
        gameFlow.runLevels(levels);
    }
}
