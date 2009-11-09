package logic;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;
import data.*;

public class FlyGuyTest {
    FlyGuy mp;
    Camera cam;
    Scene scena;

    public FlyGuyTest () {
        cam = new Camera(
                300.0,   // VPD
                500,    // RZ_HEIGHT
                500,    // RZ_WIDTH
                -400.0); // Camera Y

        scena = new Scene(ObjectLoader.getTriangleList("testy.txt"), cam);
        mp = new FlyGuy(scena);
    }
    
    @Test
    public void makeRotationXMatrixTest () {
        Matrix m;
        m = mp.makeRotationXMatrix(1);
        m.show();
    }

    public static void main (String[] args) {
        JUnitCore.main("logic.FlyGuyTest");
    }
}
