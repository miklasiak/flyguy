package logic;

/**
 * Klasa do testowania macierzy.
 * @author alebar
 */

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;

public class MatrixTest {
    private double eps;

    @Before
    public void setUp () {
        eps = 0.0001;
    }

    @Test
    public void constructTabTest () {
        Double[][] tab = {
            {1.0, 2.0, 0.0, 3.0},
            {-1.0, 2.0, 0.0, 3.0},
            {4.0, -7.3, 0.3, 8.9},
            {0.0, 2.0, 0.0, 3.0}
        };
        Matrix m = new Matrix (tab);
    }



    public static void main (String[] args) {
        JUnitCore.main("logic.PointTest");
    }

}
