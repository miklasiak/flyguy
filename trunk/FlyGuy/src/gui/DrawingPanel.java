package gui;
import logic.FlyGuy;
import logic.Line2D;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import logic.Point2D;


/**
 * Ta klasa, rozszerzająca JPanel, odpowiada za malowanie sceny na ekranie.
 * @author alebar
 */
public class DrawingPanel extends JPanel {
    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    private FlyGuy mainProgram;
    ArrayList<Line2D> linie;
    Point2D p1, p2;

    /**
     * Konstruktor tworzy obiekt klasy DrawingPanel. Ustawia odpowiedni rozmiar, kolor tła
     * oraz dodaje Listenera. Klasa DrawingPanel wywołuje metodę z głównego programu, dlatego
     * potrzebuje mieć uchwyt do niego.
     * @param mP jest to uchwyt do obiektu głównego programu 
     * @param mouseList to obiekt który będzie reagował na zachowania myszy.
     */
    public DrawingPanel (FlyGuy mP, GUI mouseList) {
        //this.addMouseListener(mouseList);
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

        linie = mainProgram.getZrzutowane();
        for (Line2D l : linie) {
            p1 = l.getPoint2D(0);
            p2 = l.getPoint2D(1);
            
            g.drawLine(
                    p1.getX(), p1.getY(),
                    p2.getX(), p2.getY()
                    );
        }       
    }

}
