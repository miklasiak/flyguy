package logic;
import gui.*;

/**
 *
 * @author alebar
 */
public class Camera {
    private gui.GUI gui;
    private Integer[] punkty = new Integer[4];

    public Camera () {
        punkty[0] = 10;
        punkty[1] = 10;
        punkty[2] = 500;
        punkty[3] = 400;
        
        gui = new GUI(this);
    }
    public void keyTypedResponse (char c) {
        if (c == 'a') {
            punkty[0] = 100;
            punkty[1] = 10;
            punkty[2] = 500;
            punkty[3] = 400;
        }
        if (c == 's') {
            punkty[0] = 100;
            punkty[1] = 10;
            punkty[2] = 500;
            punkty[3] = 400;
        }
        gui.reload();
    }
    public void mouseMoveResponse (String evt) {
        if (evt.equals("pressed")) {
            punkty[0] = 100;
            punkty[1] = 10;
            punkty[2] = 500;
            punkty[3] = 400;
        }
        if (evt.equals("released")) {
            punkty[0] = 600;
            punkty[1] = 10;
            punkty[2] = 20;
            punkty[3] = 400;
        }
        gui.reload();
    }
    public Integer [] getPunkty () {
        Integer[] ret = punkty.clone();
        return ret;
    }

}