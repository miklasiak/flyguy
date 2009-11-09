package logic;

import java.util.*;

/**
 * Klasa reprezentuje linię prostą w przestrzeni 2 wymiarowej,
 * zawierając 2 punkty 2D.
 * @author alebar
 */
public class Line2D {
    private ArrayList<Point2D> points = new ArrayList<Point2D>() {};

    /**
     * Konstruuje linię z podanych punktów.
     * @param p1 punkt typu Point2D
     * @param p2 punkt typu Point2D
     */
    public Line2D (Point2D p1, Point2D p2) {
        points.add(p1);
        points.add(p2);
    }

    /**
     * Konstruuje linię z podanej tablicy punktów
     * @param punkty jest to ArrayList<Triangle2D>
     */
    public Line2D (ArrayList<Point2D> punkty) {
        this.points = (ArrayList<Point2D>) punkty.clone();
    }

    /**
     * Metoda pozwala na dostęp do dowolnego punktu.
     * @param i - Oznacza index punktu na liście.
     * @return - Wybrany punkt.
     */
    public Point2D getPoint2D (int i){
        return points.get(i);
    }
}
