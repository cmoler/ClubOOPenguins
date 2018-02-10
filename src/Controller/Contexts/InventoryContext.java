package Controller.Contexts;

import Controller.Controller.Controller;
import Controller.Controller.InventoryController;

import java.awt.event.KeyEvent;

public class InventoryContext extends Context{

    private InventoryController inventoryController;

    public InventoryContext(InventoryController inventoryController){
        this.inventoryController = inventoryController;
    }

    @Override
    public void processKeyEvent(KeyEvent event) {

    }

}
