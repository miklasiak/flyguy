package logic;

import java.util.ArrayList;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

/**
 * Klasa testuje klasę Triangle2D.
 *
 * @author alebar
 */
public class Triangle2DTest {
    private double eps;

    @Before
    public void setUp () {
        eps = 0.001;
    }

    @Test
    public void constructTest () {
        ArrayList<Point2D> list = new ArrayList<Point2D>();
        list.add(new Point2D(10,20));
        list.add(new Point2D(20,40));
        list.add(new Point2D(30,60));
        Triangle2D tr = new Triangle2D(list);
        assertEquals (10,tr.getPoint2D(0).getX(),eps);
        assertEquals (20,tr.getPoint2D(0).getY(),eps);
        assertEquals (20,tr.getPoint2D(1).getX(),eps);
        assertEquals (40,tr.getPoint2D(1).getY(),eps);
        assertEquals (30,tr.getPoint2D(2).getX(),eps);
        assertEquals (60,tr.getPoint2D(2).getY(),eps);

    }

    public static void main (String[] args) {
        JUnitCore.main("logic.PointTest");
    }
}
