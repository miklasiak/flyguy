package logic;
import data.*;

/**
 *
 * @author alebar
 */
public class Main {

    public static void main(String args[]) {
        FlyGuy program;
        PiramidaWidzenia pw;
        Scene scena1;
        Scene scena2;

        pw = new PiramidaWidzenia(40.0, 100.0, 160.0, 30.0);

        scena1 = new Scene(ObjectLoader.getTriangleList("szescian.txt"), pw);
        scena2 = new Scene(ObjectLoader.getTriangleList("pkin.txt"), pw);

        program = new FlyGuy(scena1);
    }

}
