package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public class GameContext extends Context{

    public GameContext(MainController mainController){
        setMainController(mainController);
    }

    @Override
    public void processKeyEvent(KeyEvent event) {

    }
}
