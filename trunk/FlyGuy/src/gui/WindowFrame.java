package gui;

import java.awt.Container;
import javax.swing.*;
/**
 *
 * @author alebar
 */
public class WindowFrame extends JFrame {
    private final int X_WINDOW_LOCATION = 300;
    private final int Y_WINDOW_LOCATION = 100;

    public WindowFrame (JPanel drawingPanel, GUI keyList) {
        this.addKeyListener(keyList);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocation(X_WINDOW_LOCATION, Y_WINDOW_LOCATION);

        addComponents(this.getContentPane(), drawingPanel);
        pack();
    }

    private void addComponents(Container pane, JPanel drawingPanel) {

        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

        drawingPanel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        pane.add(drawingPanel);
    }

}
