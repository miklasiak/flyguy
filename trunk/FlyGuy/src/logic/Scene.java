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

    /**
     * Konstruuje scenę z podanych powierzchni i zdefiniowanej piramidy widzenia.
     * @param tList lista trójkątów typu Triangle3D, budujących obiekty w scenie
     * @param p Obiekt klasy PiramidaWidzenia
     */
    public Scene (ArrayList<Triangle3D> tList, PiramidaWidzenia p) {
        trojkaty = tList;
        pw = p;
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

}
