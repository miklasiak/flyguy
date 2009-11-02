package logic;

import data.ObjectLoader;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;

/**
 *
 * @author alebar
 */
public class SceneTest {
    private double eps;
    private Scene scena;
    private PiramidaWidzenia pw;
    private ArrayList<Triangle3D> tBefore;
    private ArrayList<Triangle3D> tAfter;
    private int tSize;

    public SceneTest () {
        pw = new PiramidaWidzenia(
                10.0,   // VPD
                -10.0,  // FPD
                50.0,   // BPD
                90.0,   // FI
                100,    // RZ_HEIGHT
                100,    // RZ_WIDTH
                -40.0); // Camera Y
        tBefore = ObjectLoader.getTriangleList("testy.txt");
        tSize = tBefore.size();
        scena = new Scene(tBefore, pw);
    }

    @Before
    public void setUp () {
        eps = 0.001;
    }

    @Test
    public void getTrojkatySizeTest () {
        tAfter = scena.getTrojkaty();
        assertEquals (tSize,tAfter.size());
    }

    @Test
    public void getTrojkatyTest () {
        Triangle3D tB, tA;
        Point pB, pA;
        tAfter = scena.getTrojkaty();
        for (int i=0; i<tSize; i++) {
            tB = tBefore.get(i);
            tA = tAfter.get(i);
            for (int j=0; j<3; j++) {
                pB = tB.getPoint(j);
                pA = tA.getPoint(j);
                assertEquals (pB.getX(),pA.getX(), eps);
                assertEquals (pB.getY(),pA.getY(), eps);
                assertEquals (pB.getZ(),pA.getZ(), eps);
            }
        }
    }

    
    @Test
    public void multiplyTest () {
        Triangle3D tB, tA;
        Point pB, pA;

        Matrix m = new Matrix('I');
        m.setVal(0, 3, 1.0); // x+1
        m.setVal(1, 3, 2.0); // y+2
        m.setVal(2, 3, 3.0); // z+3

        scena.multiplyPoints(m);
        tAfter = scena.getTrojkaty();

        for (int i=0; i<tSize; i++) {
            tB = tBefore.get(i);
            tA = tAfter.get(i);
            for (int j=0; j<3; j++) {
                pB = tB.getPoint(j);
                pA = tA.getPoint(j);
                assertEquals (pB.getX()+1,pA.getX(), eps);
                assertEquals (pB.getY()+2,pA.getY(), eps);
                assertEquals (pB.getZ()+3,pA.getZ(), eps);
            }
        }
    }

    public static void main (String[] args) {
        JUnitCore.main("logic.PointTest");
    }

}
