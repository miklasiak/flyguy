package logic;

/**
 * Klasa reprezentuje piramidę widzenia kamery. Kamera siedzi w punkcie [0,yc,0]
 * i skierowana jest na środek układu współrzędnych.
 * @author alebar
 */
public class Camera {
    /**
     * VPD (View Plane Distance) czyli odległość rzutni od środka rzutowania
     */
    private double VPD;
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


    public Camera (double vpd, int rz_height, int rz_width, double y) {
        VPD = vpd;
        yc = y;
        RZUTNIA_HEIGHT = rz_height;
        RZUTNIA_WIDTH = rz_width;
    }

    /**
     * Funkcja sprawdza, czy przekazany jej punkt p
     * znajduje się przed rzutnią.
     * @param p Punkt do sprawdzenia
     * @return true jeśli p jest przed rzutnią, false jeśli nie
     */
    protected boolean isVisible(Point p) {
        if (p.getY() >= yc+VPD) return true;
        else return false;
    }

    /**
     * Zmienia odległość rzutni od środka rzutowania.
     * @param d - Nowa odległość rzutni.
     */
    protected void setVPD (double d) {
        if (d>0)
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
