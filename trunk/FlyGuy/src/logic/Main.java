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
        Scene scena0;
        Scene scena1;
        Scene scena2;

        pw = new PiramidaWidzenia(
                10.0,   // VPD
                -10.0,  // FPD
                50.0,   // BPD
                97.0,   // FI
                500,    // RZ_HEIGHT
                500,    // RZ_WIDTH
                -40.0); // Camera Y

         //scena0 = new Scene(ObjectLoader.getTriangleList("testy.txt"), pw);
        scena1 = new Scene(ObjectLoader.getTriangleList("szescian.txt"), pw);
        //scena2 = new Scene(ObjectLoader.getTriangleList("pkin.txt"), pw);

        program = new FlyGuy(scena1);
    }

}
