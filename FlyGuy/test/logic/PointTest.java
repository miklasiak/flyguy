package logic;

/**
 * Proste testy do testowania klasy Point
 * @author alebar
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;

public class PointTest {
    private double eps;
    
    @Before
    public void setUp () {
        eps = 0.001;
    }

    @Test
    public void constructTest1 () {
        Point p = new Point();
        assertEquals (0.0,p.getX(),eps);
        assertEquals (0.0,p.getY(),eps);
        assertEquals (0.0,p.getZ(),eps);
        assertEquals (1.0,p.getN(),eps);
    }

    @Test
    public void getVectorTest () {
        Point p = new Point ();
        Double[] v;

        p.setN(1.0);
        p.setX(20.0);
        p.setY(10.0);
        p.setZ(0.0);
        try {
            v = p.getVector();
            assertEquals (v[0],p.getX(),eps);
            assertEquals (v[1],p.getY(),eps);
            assertEquals (v[2],p.getZ(),eps);
            assertEquals (v[3],p.getN(),eps);

            assertEquals (v[0],20.0,eps);
            assertEquals (v[1],10.0,eps);
            assertEquals (v[2],0.0,eps);
            assertEquals (v[3],1.0,eps);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main (String[] args) {
        JUnitCore.main("logic.PointTest");
    }

}
