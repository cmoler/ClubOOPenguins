package Controller.MainControl;

import Controller.Contexts.Context;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private Context activeContext;

    Input(Context activeContext) {
        this.activeContext = activeContext;
    }

    public void setActiveContext(Context context){
        this.activeContext = context;
    }

    private void forwardKeyEvent(KeyEvent event){
        //activeContext.setLastEvent(event);
        System.out.println("Active context in input is " + activeContext.getClass().toString());
        activeContext.processKeyEvent(event);
    }

    public void keyTyped(KeyEvent event) {

    }

    public void keyPressed(KeyEvent event) {
        forwardKeyEvent(event);
    }

    public void keyReleased(KeyEvent event) {

    }
}
