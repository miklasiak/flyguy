package gui;
import logic.FlyGuy;
import java.awt.event.*;
/**
 * Ta klasa odpowiada za GUI programu. Program wywołuje konstruktor tej klasy
 * by stworzyć okno. Żeby przemalować scenę wystarczy wywołać reload().
 * @author alebar
 */
public class GUI implements MouseListener, KeyListener {
    private DrawingPanel panel;
    private WindowFrame frame;
    private FlyGuy mainProgram;

    public GUI (FlyGuy mP) {
        mainProgram = mP;
        panel = new DrawingPanel(mP, this);
        frame = new WindowFrame(panel, this);
        frame.setVisible(true);
    }

    /**
     * Wywołaj tę funkcję, żeby przemalować scenę.
     */
    public void reload () {
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("exited");
    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("GUI: typed");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("GUI: pressed "+KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("GUI: released "+KeyEvent.getKeyText(e.getKeyCode()));
    }

}
