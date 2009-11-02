package logic;
import gui.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author alebar
 */
public class FlyGuy {
    private Timer timer = new Timer();
    private gui.GUI gui;
    private ArrayList<Triangle2D> zrzutowane;
    private Scene scena;
    private boolean changed = true;
    private double tStep = 1.0;
    private Double[] v;                 // wektor translacji
    private Matrix T = new Matrix('I'); // macierz translacji
    private Matrix R = new Matrix('I'); // macierz obrotu

    public FlyGuy (Scene s) {
        timer.scheduleAtFixedRate(new MyTimerTask(), 500, 100);
        v = new Double[3];
        for (int i=0; i<3; i++)
            v[i]=0.0;
        scena = s;
        zrzutowane = scena.rzutuj();
        gui = new GUI(this);
    }

    public ArrayList<Triangle2D> getZrzutowane () {
        return (ArrayList<Triangle2D>) zrzutowane.clone();
    }
    
    //<editor-fold defaultstate="collapsed" desc=" moveRight/Left/itd">
    public void moveRight () {
        v[0] -= tStep;
        changed = true;
    }

    public void moveLeft () {
        v[0] += tStep;
        changed = true;
    }

    public void moveForward () {
        v[1] -= tStep;
        changed = true;
    }

    public void moveBackward () {
        v[1] += tStep;
        changed = true;
    }

    public void moveUp () {
        v[2] -= tStep;
        changed = true;
    }

    public void moveDown () {
        v[2] += tStep;
        changed = true;
    }
    //</editor-fold>

    private class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (changed) {
                for (int w=0; w<3; w++)
                    T.setVal(w, 3, v[w]);
                T.multiple(R);
                scena.multiplyPoints(T);
                zrzutowane = scena.rzutuj();
                T.makeMeI();
                for (int i=0; i<3; i++)
                    v[i] = 0.0;
                gui.reload();
                changed = false;
            }
        }

    }

}