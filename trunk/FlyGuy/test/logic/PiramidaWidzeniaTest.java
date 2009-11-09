/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author alebar
 */
public class PiramidaWidzeniaTest {

    public PiramidaWidzeniaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testIsInside() {
        Point p1 = new Point(20,0,0);
        Point p2 = new Point(20,-31,0);
        Camera pw;
        pw = new Camera(
                10.0,   // VPD
                500,    // RZ_HEIGHT
                500,    // RZ_WIDTH
                -40.0); // Camera Y
        assertEquals(false, pw.isVisible(p2));
        assertEquals(true, pw.isVisible(p1));
        
    }

}