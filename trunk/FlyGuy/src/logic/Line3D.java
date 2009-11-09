package logic;

import java.util.*;

/**
 * Klasa reprezentuje linię prostą w przestrzeni 3 wymiarowej,
 * zawierając 2 punkty przestrzenne.
 * @author alebar
 */
public class Line3D {
    private ArrayList<Point> points = new ArrayList<Point>() {};

    /**
     * Konstruuje linię z podanych punktów.
     * @param p1
     * @param p2
     */
    public Line3D (Point p1, Point p2) {
        points.add(p1);
        points.add(p2);
    }

    /**
     * Metoda pozwala na dostęp do dowolnego punktu.
     * @param i - Oznacza index punktu na liście.
     * @return - Wybrany punkt.
     */
    public Point getPoint (int i){
        return points.get(i);
    }

    public static Line3D copy (Line3D l) {
        Point [] p = new Point[2];
        for (int i=0; i<2; i++) {
            p[i] = new Point(
                    l.getPoint(i).getX(),
                    l.getPoint(i).getY(),
                    l.getPoint(i).getZ());
        }
        return new Line3D(p[0], p[1]);
    }
}
