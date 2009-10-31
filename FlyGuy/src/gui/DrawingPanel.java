package gui;
import logic.FlyGuy;
import logic.Triangle2D;
import logic.Point2D;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;


/**
 * Ta klasa, rozszerzająca JPanel, odpowiada za malowanie sceny na ekranie.
 * @author alebar
 */
public class DrawingPanel extends JPanel {
    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    private FlyGuy mainProgram;
    ArrayList<Triangle2D> trojkaty;
    int[] x = new int[3];
    int[] y = new int[3];

    /**
     * Konstruktor tworzy obiekt klasy DrawingPanel. Ustawia odpowiedni rozmiar, kolor tła
     * oraz dodaje Listenera. Klasa DrawingPanel wywołuje metodę z głównego programu, dlatego
     * potrzebuje mieć uchwyt do niego.
     * @param mP jest to uchwyt do obiektu głównego programu 
     * @param mouseList to obiekt który będzie reagował na zachowania myszy.
     */
    public DrawingPanel (FlyGuy mP, GUI mouseList) {
        this.addMouseListener(mouseList);
        mainProgram = mP;
        
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        
        this.setBackground(Color.BLACK);
    }

    /**
     * Przesłonięta metoda paintComponent(g) pobiera odpowiednie dane
     * z programu głównego i maluje je na ekranie w panelu.
     * @param g obiekt klasy Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        trojkaty = mainProgram.getZrzutowane();

        for (Triangle2D t : trojkaty) {
            for (int i=0; i<3; i++) {
                x[i] = t.getPoint2D(i).getX();
                y[i] = t.getPoint2D(i).getY();
            }
            g.drawPolygon(x, y, 3);
        }       
    }

}
