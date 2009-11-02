package logic;

/**
 * Klasa repreentuje zwykły, normalny punkt w przestrzeni 3D.
 * @author alebar
 */
public class Point {
    private Double[] v;

    /**
     * Konstruktor tworzy punkt o współrzędnych jednorodnych znormalizowanych [0,0,0,1.0].
     */
    public Point () {
        v = new Double[4];
        v[0] = 0.0;
        v[1] = 0.0;
        v[2] = 0.0;
        v[3] = 1.0;
    }
    
    /**
     * Konstruktor tworzy punkt o współrzędnych jednorodnych znormalizowanych [x,y,z,1].
     * @param x
     * @param y
     * @param z
     */
    public Point (double x, double y, double z) {
        v = new Double[4];
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = 1.0;
    }

    /**
     * Mnoży punkt przez macierz m. Wynik nadpisuje dotychczasowe współrzędne punktu.
     * @param m
     */
    protected void multiply (Matrix m) {
        Double [] tmp = new Double[4];
        Double[][] mat = m.getTab();
        
        for (int w =0; w<4; w++) {
            tmp[w] = 0.0;
            for (int k=0; k<4; k++) {
                tmp[w] += mat[w][k]*v[k];
            }
        }
        v = tmp.clone();
    }

    /**
     * Ta metoda normalizuje punkt o współrzędnych jednorodnych.
     */
    protected void normalize () {
        v[0] = v[0]*(1/v[3]);
        v[1] = v[1]*(1/v[3]);
        v[2] = v[2]*(1/v[3]);
        v[3] = 1.0;
    }

    public double getX () { return v[0]; }
    public double getY () { return v[1]; }
    public double getZ () { return v[2]; }
    public double getN () { return v[3]; }

    protected void setX (double x) { v[0] = x; }
    protected void setY (double y) { v[1] = y; }
    protected void setZ (double z) { v[2] = z; }
    protected void setN (double N) { v[3] = N; }

    /**
     * Zwraca 4 elementową tablicę współrzędnych punktu.
     * Wyrzuca wyjątek w przypadku jeśli próbujemy uzyskać tablicę punktu, który
     * nie został zainicjowany.
     * @return
     * @throws java.lang.Exception
     */
    protected Double[] getVector () throws Exception {
        if (v == null)
            throw new Exception ("punkt nie zainicjowany");
        return v.clone();
    }
}
