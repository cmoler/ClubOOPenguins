package Controller.Contexts;

import Controller.MainControl.MainController;

import java.awt.event.KeyEvent;

public class InventoryContext extends Context{

    public InventoryContext(MainController mainController) {
        super(mainController);
    }

    @Override
    public void processKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        MainController mainController = getMainController();

        switch(keyCode){

            case KeyEvent.VK_ESCAPE:
                mainController.closeInventory();
                break;
        }
    }
}
