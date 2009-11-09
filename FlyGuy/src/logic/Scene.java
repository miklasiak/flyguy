package logic;

import java.util.ArrayList;

/**
 * Klasa definiująca świat, czyli całą scenę. Klasa zawiera wszystkie figury
 * (trójkąty), z których składają się obiekty.
 * @author alebar
 */
public class Scene {
    private ArrayList<Line3D> linie = new ArrayList<Line3D>();
    private Camera cam;
    private int xd, zd;

    /**
     * Konstruuje scenę z podanych powierzchni i zdefiniowanej piramidy widzenia.
     * @param tList lista trójkątów typu Triangle3D, budujących obiekty w scenie
     * @param p Obiekt klasy PiramidaWidzenia
     */
    public Scene (ArrayList<Line3D> tList, Camera p) {
        listCopy(tList); // tList wkleja na listę "linie"
        cam = p;
        xd = cam.getRzutniaWidth() / 2;
        zd = cam.getRzutniaHeight() / 2;
    }

    private void listCopy (ArrayList<Line3D> list) {
        for (Line3D l : list) {
            linie.add(Line3D.copy(l));
        }
    }

    /**
     * Pozwala na zmianę długości ogniskowej.
     * @param delta odległość o jaką ogniskowa ma być zwiększona.
     */
    protected void zmienOgniskowa (double delta) {
        cam.setVPD(cam.getVPD()+delta);
    }

    /**
     * Metoda ta mnoży wszystkie elementy przez podaną macierz przeszktałcenia.
     * @param M - macierz 4x4 zawierająca zbiorcze przekształcenie
     */
    protected void multiplyPoints(Matrix M) {
        Point tmp;
        for (Line3D l : linie) {
            for (int p=0; p<2; p++) {
                tmp = l.getPoint(p);
                tmp.multiply(M);
                tmp.normalize();
            }
        }
    }

    /**
     * Metoda rzutuje trójwymiarowe linie na rzutnię. Rzutuje tylko te
     * linie proste, które (przynajmniej jednym punktem) znajdują się w piramidzie widzenia.
     * W wyniku zwraca listę linii prostych dwuwymiarowych, o współrzędnych przeliczonych na
     * współrzędne rzutni (ekranu).
     * @return lista linii widocznych na rzutni
     */
    protected ArrayList<Line2D> rzutuj () {
        ArrayList<Line2D> obraz = new ArrayList<Line2D>();
        ArrayList<Point2D> punkty = new ArrayList<Point2D>();

        for (Line3D line3d : linie) {
            Point p1, p2;
            Line2D line2d;

            p1 = line3d.getPoint(0);
            p2 = line3d.getPoint(1);

            if (cam.isVisible(p1)&&cam.isVisible(p2)) {
                line2d = rzutujNormalnie(p1,p2);
                obraz.add(line2d);
            }
            else if (cam.isVisible(p1)&&(!cam.isVisible(p2))) {
                line2d = rzutujZCieciem (p1, p2);
                obraz.add(line2d);
            }
            else if ((!cam.isVisible(p1))&&cam.isVisible(p2)) {
                line2d = rzutujZCieciem (p2, p1); //najpierw widoczny, potem niewidoczny
                obraz.add(line2d);
            }
        }

        return obraz;
    }

    protected ArrayList<Line3D> getLines () {
        return (ArrayList<Line3D>) linie.clone();
    }

    private Line2D rzutujNormalnie(Point p1, Point p2) {
        return new Line2D(rzucPunkt(p1), rzucPunkt(p2));
    }

    private Line2D rzutujZCieciem(Point a, Point b) {
        // p1 jest widoczny, p2 nie widac
        Point2D nowy1, nowy2;
        if (a.getY() == (cam.getY()+cam.getVPD())) {
            nowy1 = new Point2D(
                    (int)(a.getX() + xd),
                    (int)(zd - a.getZ())
                    );
            nowy2 = new Point2D(nowy1.getX(), nowy1.getY());
            return new Line2D (nowy1, nowy2);
        }
        else {
            double Y = a.getY() - b.getY();
            double y = a.getY() - ( cam.getY() + cam.getVPD() );
            double x, z, k;
            k = y/Y;
            x = a.getX() + ( (b.getX() - a.getX() ) * k );
            z = a.getZ() + ( (b.getZ() - a.getZ() ) * k );
            return new Line2D ( rzucPunkt(a), new Point2D((int)(xd+x), (int)(zd-z)));
        }
    }

    private Point2D rzucPunkt (Point p) {
        double k = cam.getVPD() / (p.getY()-cam.getY());
        int x = (int) (k*p.getX()+xd);
        int z = (int) (zd - k*p.getZ());
        return new Point2D (x,z);
    }

    protected double getCameraY () {
        return this.cam.getY();
    }

}