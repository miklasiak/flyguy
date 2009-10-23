package gui;
import logic.Camera;
import java.awt.event.*;
/**
 *
 * @author alebar
 */
public class GUI implements MouseListener, KeyListener {
    private DrawingPanel panel;
    private WindowFrame frame;
    private Camera mainProgram;

    public GUI (Camera mP) {
        mainProgram = mP;
        panel = new DrawingPanel(mP, this);
        frame = new WindowFrame(panel, this);
        frame.setVisible(true);
    }

    public void reload () {
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mainProgram.mouseMoveResponse("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mainProgram.mouseMoveResponse("released");
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
        System.out.println("GUI: typed");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("GUI: pressed");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("GUI: released");
    }

}
