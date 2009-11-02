package logic;

/**
 * Klasa reprezentuje piramidę widzenia kamery. Kamera siedzi w punkcie [0,yc,0]
 * i skierowana jest na środek układu współrzędnych.
 * @author alebar
 */
public class PiramidaWidzenia {
    /**
     * VPD (View Plane Distance) czyli odległość rzutni od środka rzutowania
     */
    private double VPD;
    /**
     * FPD (Front Plane Distance) - współrzędna Y przedniej płaszczyzny przycinającej
     */
    private final double FPD;
    /**
     * BPD (Back Plane Distance) - współrzędna Y tylniej płaszczyzny przycinającej
     */
    private final double BPD;
    /**
     * Kąt widzenia kamery.
     */
    private final double FI;
    /**
     * Połowa szerokości prostopadłościanu tnącego. Rzutowane będą tylko te punkty, które
     * znajdują się w prostopadłościanie. Jego szerokość i wysokość są takie same -
     * związane z kątem widzenia. Długość prostopadłościanu to BPD-FPD.
     */
    private final double a;
    /**
     * Wysokość rzutni w pikselach
     */
    private final int RZUTNIA_HEIGHT;
    /**
     * Szerokość rzutni w pikselach
     */
    private final int RZUTNIA_WIDTH;
    /**
     * Współrzędne kamery w osi OY.
     */
    private double yc;


    public PiramidaWidzenia (double vpd, double fpd, double bpd, double fi, int rz_height, int rz_width, double y) {
        VPD = vpd;
        FPD = fpd;
        BPD = bpd;
        FI = fi;
        yc = y;
        a = BPD*java.lang.Math.abs(java.lang.Math.tan(FI/2));
        RZUTNIA_HEIGHT = rz_height;
        RZUTNIA_WIDTH = rz_width;
    }

    /**
     * Funkcja sprawdza, czy przekazany jej punkt p
     * znajduje się wewnątrz prostopadłościanu tnącego.
     * Zwraca true jeśli tak a jeśli nie to false.
     * @param p Punkt do sprawdzenia
     * @return
     */
    protected boolean isInside(Point p) {
        boolean ans = true;
        if (p.getX()>a || p.getX()<a*(-1))
            ans = false;
        if (p.getY()>BPD || p.getY()<FPD || p.getY()<=(VPD+yc))
            ans = false;
        if (p.getZ()>a || p.getZ()<a*(-1))
            ans = false;
        return ans;
    }

    /**
     * Zmienia odległość rzutni od środka rzutowania.
     * @param d - Nowa odległość rzutni.
     */
    protected void setVPD (double d) {
        this.VPD = d;
    }

    /**
     * Zwraca odległość rzutni od środka rzutowania
     * @return odległość rzutni od środka rzutowania
     */
    protected double getVPD () {
        return this.VPD;
    }

    /**
     * Zwraca wysokość rzutni w pikselach.
     * @return wysokość rzutni w pikselach
     */
    protected int getRzutniaHeight () {
        return this.RZUTNIA_HEIGHT;
    }
    /**
     * Zwraca szerokość rzutni w pikselach.
     * @return szerokość rzutni w pikselach
     */
    protected int getRzutniaWidth () {
        return this.RZUTNIA_WIDTH;
    }

    /**
     * Zwraca współrzędną y pozycji kamery.
     * @return współrzędna y pozycji kamery
     */
    protected double getY () {
        return yc;
    }

    protected void setY(double y) {
        yc += y;
    }
}
