package Controller.Controller;

import Controller.Contexts.GameContext;
import Model.Entity.Equipment;
import Model.Item.TakeableItem;
import Model.Map.Direction;

public class EquipmentController implements Controller {

    private MainController mainController;
    private Equipment equipment;

    public EquipmentController(MainController mainController){
        this.mainController = mainController;
    }


    public void setEquipment(Equipment equipment){
        this.equipment = equipment;
    }

    @Override
    public void handleEscape() {
        mainController.setActiveContext(GameContext.MENU);
    }

    @Override
    public void handleI() {
        mainController.setActiveContext(GameContext.INVENTORY);
    }

    @Override
    public void handleT() {
        mainController.setActiveContext(GameContext.AREA);
    }

    @Override
    public void handleEnter() {
        TakeableItem equippedItem = equipment.getEquipped();
        equipment.unEquip(equippedItem);
    }

    @Override
    public void handleNumpad(Direction direction) {
        //does nothing now
    }

}