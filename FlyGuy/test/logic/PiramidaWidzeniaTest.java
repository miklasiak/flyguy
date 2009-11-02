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
        Point p2 = new Point(20,-15,0);
        PiramidaWidzenia pw;
        pw = new PiramidaWidzenia(
                10.0,   // VPD
                -10.0,  // FPD
                50.0,   // BPD
                90.0,   // FI
                500,    // RZ_HEIGHT
                500,    // RZ_WIDTH
                -40.0); // Camera Y
        assertEquals(false, pw.isInside(p2));
        assertEquals(true, pw.isInside(p1));
        
    }

}