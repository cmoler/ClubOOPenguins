package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public class MenuContext extends Context{

    public MenuContext(MainController mainController){
        super(mainController);
    }

    public void processKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        MainController mainController = getMainController();

        switch(keyCode){

            case KeyEvent.VK_ESCAPE:
                mainController.closeMenu();
                break;

        }
    }
}
