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

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w')
            mainProgram.moveForward();
        if (e.getKeyChar() == 's')
            mainProgram.moveBackward();
        if (e.getKeyChar() == 'a')
            mainProgram.moveLeft();
        if (e.getKeyChar() == 'd')
            mainProgram.moveRight();
        if (e.getKeyCode() == 'R' || e.getKeyCode() == 'r')
            mainProgram.moveUp();
        if (e.getKeyCode() == 'F' || e.getKeyCode() == 'f')
            mainProgram.moveDown();
        if (e.getKeyCode()==KeyEvent.VK_UP)
            mainProgram.rotateXUp();
        if (e.getKeyCode()==KeyEvent.VK_DOWN)
            mainProgram.rotateXDown();
        if (e.getKeyChar() == '[')
            mainProgram.zoomIn();
        if (e.getKeyChar() == ']')
            mainProgram.zoomOut();
    }

    public void keyReleased(KeyEvent e) { }

}
