package Controller.Contexts;

import Controller.Controller.Controller;
import Controller.Controller.EquipmentController;
import Controller.Controller.MainController;
import Model.Entity.Equipment;


import java.awt.event.KeyEvent;

public class EquipmentContext extends Context{

    private EquipmentController equipmentController;

    public EquipmentContext(EquipmentController equipmentController) {
        this.equipmentController = equipmentController;
    }

    public Controller getController() {
        return equipmentController;
    }

    public void setController(EquipmentController controller) {
        equipmentController = controller;
    }

    @Override
    public void processKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();

        switch(keyCode){

            case KeyEvent.VK_ESCAPE:

                break;
        }
    }
}
