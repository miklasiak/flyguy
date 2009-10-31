package logic;

import java.util.*;

/**
 * Klasa reprezentuje trójkąt w przestrzeni 3 wymiarowej,
 * zawierając 3 punkty przestrzenne.
 * @author alebar
 */
public class Triangle3D {
    private ArrayList<Point> points = new ArrayList<Point>() {};

    /**
     * Konstruuje trójkąt z podanych punktów.
     * @param p1
     * @param p2
     * @param p3
     */
    public Triangle3D (Point p1, Point p2, Point p3) {
        points.add(p1);
        points.add(p2);
        points.add(p3);
    }

    /**
     * Metoda pozwala na dostęp do dowolnego punktu.
     * @param i - Oznacza index punktu na liście.
     * @return - Wybrany punkt.
     */
    public Point getPoint (int i){
        return points.get(i);
    }
}
