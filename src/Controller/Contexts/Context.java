package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public abstract class Context {

    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public abstract void processKeyEvent(KeyEvent event);

}
