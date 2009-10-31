package gui;
import logic.FlyGuy;
import javax.swing.JPanel;
import java.awt.*;


/**
 * Ta klasa, rozszerzająca JPanel, odpowiada za malowanie sceny na ekranie.
 * @author alebar
 */
public class DrawingPanel extends JPanel {
    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    private FlyGuy mainProgram;

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
     * Przesłonięta metoda paintComponent(g) mojego autorstwa pobiera odpowiednie dane
     * z programu głównego i maluje je na ekranie w panelu.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawRect(20, 30, 130, 300);
    }

}
