package logic;

import java.util.*;

/**
 * Klasa reprezentuje trójkąt w przestrzeni 2 wymiarowej,
 * zawierając 3 punkty 2D.
 * @author alebar
 */
public class Triangle2D {
    private ArrayList<Point2D> points = new ArrayList<Point2D>() {};

    /**
     * Konstruuje trójkąt z podanych punktów.
     * @param p1 punkt typu Point2D
     * @param p2 punkt typu Point2D
     * @param p3 punkt typu Point2D
     */
    public Triangle2D (Point2D p1, Point2D p2, Point2D p3) {
        points.add(p1);
        points.add(p2);
        points.add(p3);
    }

    /**
     * Konstruuje trójkąt z podanej tablicy punktów
     * @param punkty jest to ArrayList<Triangle2D>
     */
    public Triangle2D (ArrayList<Point2D> punkty) {
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
