package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public class GameContext extends Context{

    public GameContext(MainController mainController){
        super(mainController);
    }

    public void processKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        MainController mainController = getMainController();

        switch(keyCode){

            case KeyEvent.VK_I:
                mainController.openInventory();
                break;

            case KeyEvent.VK_ESCAPE:
                mainController.openMenu();
                break;


        }
    }
}
