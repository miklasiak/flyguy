package logic;

/**
 * Klasa repreentuje zwykły, normalny punkt w przestrzeni 2D. Punkt ma współrzędne
 * typu int, gdyż reprezentują pixele na ekranie.
 * @author alebar
 */
public class Point2D {
    private int[] v;

    /**
     * Konstruktor tworzy punkt o współrzędnych [0,0].
     */
    public Point2D () {
        v = new int[2];
        v[0] = 0;
        v[1] = 0;
    }
    
    /**
     * Konstruktor tworzy punkt o współrzędnych [x,y].
     * @param x współrzędna x
     * @param y współrzędna y
     */
    public Point2D (int x, int y) {
        v = new int[2];
        v[0] = x;
        v[1] = y;
    }

    /**
     * Pobierz współrzędną x punktu.
     * @return współrzędna x
     */
    public int getX () { return v[0]; }
    /**
     * Pobierz współrzędną y punktu.
     * @return współrzędna y
     */
    public int getY () { return v[1]; }

    /**
     * Ustaw współrzędną x punktu.
     * @param x nowa współrzędna x punktu.
     */
    protected void setX (int x) { v[0] = x; }
    /**
     * Ustaw współrzędną y punktu.
     * @param y nowa współrzędna y punktu.
     */
    protected void setY (int y) { v[1] = y; }

    /**
     * Zwraca 2 elementową tablicę współrzędnych punktu.
     * Wyrzuca wyjątek w przypadku jeśli próbujemy uzyskać tablicę punktu, który
     * nie został zainicjowany.
     * @return 2 elementowa tablica liczb typu int
     * @throws java.lang.Exception
     */
    protected int[] getVector () throws Exception {
        if (v == null)
            throw new Exception ("punkt nie zainicjowany");
        return v.clone();
    }
}
