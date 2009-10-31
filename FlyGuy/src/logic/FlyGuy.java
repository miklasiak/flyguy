package logic;
import gui.*;

/**
 *
 * @author alebar
 */
public class FlyGuy {
    private gui.GUI gui;

    public FlyGuy (Scene scena) {
        gui = new GUI(this);
    }
}