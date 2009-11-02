package data;

import java.util.ArrayList;
import logic.Triangle3D;

import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

/**
 * Klasa testująca klasę ObjectLoader.
 * @author alebar
 */
public class ObjectLoaderTest {
    double eps;

    @Before
    public void setUp () {
        eps = 0.0001;
    }
    @Test
    public void szescianTest () {
        ArrayList<Triangle3D> t = ObjectLoader.getTriangleList("szescian.txt");
        Triangle3D testTrojkat;
        assertEquals (12,t.size(),eps);
        for (int i=0; i<t.size(); i++) {
            testTrojkat = t.get(i);
            /*
            assertEquals (-20.3,testTrojkat.getPoint(0).getX(), eps);
            assertEquals (40.0,testTrojkat.getPoint(0).getY(), eps);
            assertEquals (20.0,testTrojkat.getPoint(0).getZ(), eps);
            assertEquals (20.0,testTrojkat.getPoint(1).getX(), eps);
            assertEquals (40.0,testTrojkat.getPoint(1).getY(), eps);
            assertEquals (20.0,testTrojkat.getPoint(1).getZ(), eps);
            assertEquals (20.0,testTrojkat.getPoint(2).getX(), eps);
            assertEquals (0.0,testTrojkat.getPoint(2).getY(), eps);
            assertEquals (20.0,testTrojkat.getPoint(2).getZ(), eps);
            */
        }

    }

    public static void main (String[] args) {
        JUnitCore.main("logic.PointTest");
    }
}
