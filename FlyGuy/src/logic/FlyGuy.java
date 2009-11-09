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
    private ArrayList<Line2D> zrzutowane;
    private Scene scena;
    private boolean changed = true;
    private double tStep = 1.0;                 // krok przesuniecia w translacji
    private double dStep = 1.0;                 // krok przesuniecia ogniskowej
    private double rStep = 1.0;                 // krok przesuniecia ogniskowej
    private Double[] v;                         // wektor translacji
    private Matrix T = new Matrix('I');         // macierz translacji
    private Matrix R = new Matrix('I');         // zbiorowa macierz obrotu
    private Matrix rXdown = new Matrix('I');    // macierz obrotu wokol OX w dol
    private Matrix rXup = new Matrix('I');      // macierz obrotu wokol OX w gore

    public FlyGuy (Scene s) {
        v = new Double[3];
        for (int i=0; i<3; i++)
            v[i]=0.0;
        scena = s;
        
        rXdown = this.makeRotationXMatrix(rStep);
        rXup = this.makeRotationXMatrix(-rStep);

        zrzutowane = scena.rzutuj();
        gui = new GUI(this);
        timer.scheduleAtFixedRate(new MyTimerTask(), 500, 30);
    }

    public ArrayList<Line2D> getZrzutowane () {
        return (ArrayList<Line2D>) zrzutowane.clone();
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

    public void zoomIn () {
        scena.zmienOgniskowa(dStep);
        changed = true;
    }

    public void zoomOut () {
        scena.zmienOgniskowa((-1)*dStep);
        changed = true;
    }

    public void rotateXDown() {
        R.multiple(rXdown);
        changed = true;
    }

    public void rotateXUp() {
        R.multiple(rXup);
        changed = true;
    }

    public Matrix makeRotationXMatrix (double fi) {
        Matrix m = new Matrix('I');
        double cos, sin;
        cos = java.lang.Math.cos(fi);
        sin = java.lang.Math.sin(fi);
        m.setVal(1, 1, cos);
        m.setVal(2, 2, cos);
        m.setVal(2, 1, sin);
        m.setVal(1, 2, -sin);
        return m;
    }

    private Matrix makeRotationYMatrix (double fi) {
        Matrix m = new Matrix('I');
        double cos, sin;
        cos = java.lang.Math.cos(fi);
        sin = java.lang.Math.sin(fi);
        m.setVal(0, 0, cos);
        m.setVal(2, 2, cos);
        m.setVal(0, 2, sin);
        m.setVal(2, 0, -sin);
        return m;
    }

    private Matrix makeRotationZMatrix (double fi) {
        Matrix m = new Matrix('I');
        double cos, sin;
        cos = java.lang.Math.cos(fi);
        sin = java.lang.Math.sin(fi);
        m.setVal(0, 0, cos);
        m.setVal(1, 1, cos);
        m.setVal(1, 0, sin);
        m.setVal(0, 1, -sin);
        return m;
    }

    private class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (changed) {
                // zrob macierz translacji
                for (int w=0; w<3; w++)
                    T.setVal(w, 3, v[w]);
                
                // przemnoz translacje przez obroty
                T.multiple(R);

                scena.multiplyPoints(T);
                zrzutowane = scena.rzutuj();

                // zresetuj macierze i wektor translacji
                R.makeMeI();
                T.makeMeI();
                for (int i=0; i<3; i++)
                    v[i] = 0.0;

                gui.reload();
                changed = false;
            }
        }

    }

}