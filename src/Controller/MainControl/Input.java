package Controller.MainControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Key released code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
    }
}
