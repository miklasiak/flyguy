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
        // movement
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W')
            mainProgram.moveForward();
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S')
            mainProgram.moveBackward();
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A')
            mainProgram.moveLeft();
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D')
            mainProgram.moveRight();
        if (e.getKeyCode() == 'R' || e.getKeyCode() == 'r')
            mainProgram.moveUp();
        if (e.getKeyCode() == 'F' || e.getKeyCode() == 'f')
            mainProgram.moveDown();

        // rotation
        if (e.getKeyCode()==KeyEvent.VK_UP)
            mainProgram.rotateXUp();
        if (e.getKeyCode()==KeyEvent.VK_DOWN)
            mainProgram.rotateXDown();
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            mainProgram.rotateZRight();
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
            mainProgram.rotateZLeft();
        if (e.getKeyCode() == 'Q' || e.getKeyCode() == 'q')
            mainProgram.rotateYLeft();
        if (e.getKeyCode() == 'E' || e.getKeyCode() == 'e')
            mainProgram.rotateYRight();

        // zoom
        if (e.getKeyChar() == ']')
            mainProgram.zoomIn();
        if (e.getKeyChar() == '[')
            mainProgram.zoomOut();
    }

    public void keyReleased(KeyEvent e) { }

}
