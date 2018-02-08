package Controller.Contexts;

import Controller.Controller.Controller;

import java.awt.event.KeyEvent;

public abstract class Context {

    private KeyEvent lastEvent;

    public void setLastEvent(KeyEvent keyEvent){
        this.lastEvent = lastEvent;
    }

    public KeyEvent getLastEvent(){
        return lastEvent;
    }

    public abstract Controller getController();
    public abstract void processKeyEvent(KeyEvent event);

}