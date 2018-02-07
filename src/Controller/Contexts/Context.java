package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public abstract class Context {

    private MainController mainController;
    private KeyEvent lastEvent;

    public Context(MainController mainController){
       setMainController(mainController);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {
        return mainController;
    }

//    public void setLastEvent(KeyEvent keyEvent){
//        this.lastEvent = lastEvent;
//    }
//
//    public KeyEvent getLastEvent(){
//        return lastEvent;
//    }

    public abstract void processKeyEvent(KeyEvent event);

}