package logic;

/**
 * Klasa reprezentuje piramidę widzenia kamery.
 * @author alebar
 */
public class PiramidaWidzenia {
    /**
     * VPD (View Plane Distance) czyli odległość rzutni od środka rzutowania
     */
    private double VPD;
    /**
     * FPD (Front Plane Distance) - odległość przedniej płaszczyzny przycinającej od środka rzutowania
     */
    private final double FPD;
    /**
     * BPD (Back Plane Distance) - odległość tylniej płaszczyzny przycinającej od środka rzutowania
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


    public PiramidaWidzenia (double vpd, double fpd, double bpd, double fi) {
        VPD = vpd;
        FPD = fpd;
        BPD = bpd;
        FI = fi;
        a = BPD*java.lang.Math.tan(fi/2);
    }

    /**
     * Funkcja sprawdza, czy przekazany jej punkt p
     * znajduje się wewnątrz prostopadłościanu tnącego.
     * Zwraca true jeśli tak a jeśli nie to false.
     * @param p
     * @return
     */
    protected boolean isInside(Point p) {
        boolean ans = true;
        if (p.getX()>a || p.getX()<a*(-1))
            ans = false;
        if (p.getY()>BPD || p.getY()<FPD)
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
}
