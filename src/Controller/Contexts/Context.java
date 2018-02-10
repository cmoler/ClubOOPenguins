package Controller.Contexts;

import java.awt.event.KeyEvent;


public abstract class Context {

    private KeyEvent lastEvent;

    public abstract void processKeyEvent(KeyEvent event);

    public final void setLastEvent(KeyEvent keyEvent){
        this.lastEvent = keyEvent;
    }

    public final KeyEvent getLastEvent(){
        return lastEvent;
    }

}