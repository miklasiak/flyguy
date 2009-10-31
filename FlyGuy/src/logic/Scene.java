package logic;

import java.util.ArrayList;

/**
 * Klasa definiująca świat, czyli całą scenę. Klasa zawiera wszystkie figury
 * (trójkąty), z których składają się obiekty.
 * @author alebar
 */
public class Scene {
    private ArrayList<Triangle3D> trojkaty = new ArrayList<Triangle3D>();
    private PiramidaWidzenia pw;
    private int xd;
    private int zd;

    /**
     * Konstruuje scenę z podanych powierzchni i zdefiniowanej piramidy widzenia.
     * @param tList lista trójkątów typu Triangle3D, budujących obiekty w scenie
     * @param p Obiekt klasy PiramidaWidzenia
     */
    public Scene (ArrayList<Triangle3D> tList, PiramidaWidzenia p) {
        trojkaty = tList;
        pw = p;
        xd = pw.getRzutniaWidth() / 2;
        zd = pw.getRzutniaHeight() / 2;
    }

    /**
     * Metoda ta mnoży wszystkie elementy przez podaną macierz przeszktałcenia.
     * @param M - macierz 4x4 zawierająca zbiorcze przekształcenie
     */
    protected void multiplyPoints(Matrix M) {
        Point tmp;
        for (Triangle3D t : trojkaty) {
            for (int p=0; p<3; p++) {
                tmp = t.getPoint(p);
                tmp.multiply(M);
                try {
                    tmp.normalize();
                } catch (Exception ex) {
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Metoda rzutuje trójwymiarowe płaszczyzny na rzutnię. Rzutuje tylko te
     * trójkąty, które (przynajmniej jednym punktem) znajdują się w piramidzie widzenia.
     * W wyniku zwraca listę trójkątów dwuwymiarowych, o współrzędnych przeliczonych na 
     * współrzędne rzutni (ekranu).
     * @return lista trójkątów widocznych na rzutni
     */
    protected ArrayList<Triangle2D> rzutuj () {
        ArrayList<Triangle2D> obraz = new ArrayList<Triangle2D>();
        ArrayList<Point2D> punkty = new ArrayList<Point2D>();

        boolean isInside;
        int i;

        for (Triangle3D t3d : trojkaty) {
            isInside = false;
            // sprawdz czy trojkat jest w piramidzie widzenia
            for (i=0; i<3; i++) {
                // jesli choc 1 punkt jest wewnatrz piramidy, nie sprawdzaj dalej
                if(isInside = pw.isInside(t3d.getPoint(i)))
                    break;
            }
            if (isInside) {
                // stworz trojkat2d z odpowiednimi wspolrzednymi i wrzuc na liste
                punkty.clear();
                for (i=0; i<3; i++) {
                    Point p3d = t3d.getPoint(i);
                    double k = pw.getVPD() / p3d.getY();
                    int x = (int) (k*p3d.getX()+xd);
                    int z = (int) (zd - k*p3d.getZ());
                    punkty.add(new Point2D(x,z));
                }
                obraz.add(new Triangle2D(punkty));
            }
            else
                continue;
        }

        return obraz;
    }
}