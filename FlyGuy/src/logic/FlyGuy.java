package logic;
import gui.*;
import java.util.ArrayList;

/**
 *
 * @author alebar
 */
public class FlyGuy {
    private gui.GUI gui;
    private ArrayList<Triangle2D> zrzutowane;
    private Scene scena;

    public FlyGuy (Scene s) {
        scena = s;
        zrzutowane = scena.rzutuj();
        gui = new GUI(this);
    }
    public ArrayList<Triangle2D> getZrzutowane () {
        return (ArrayList<Triangle2D>) zrzutowane.clone();
    }
}