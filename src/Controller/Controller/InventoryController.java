package Controller.Controller;

import Configs.InventorySizes;
import Controller.Contexts.GameContext;
import Model.Entity.Equipment;
import Model.Entity.Inventory;
import Model.Item.Item;
import Model.Item.TakeableItem;
import Model.Map.Direction;
import View.StatusView.StatusViewPort;

public class InventoryController implements Controller {

    private MainController mainController;
    private int viewItemIndex;
    private Inventory inventory;
    private Equipment equipment;
    private Inventory.InventoryIterator inventoryIterator;

    public InventoryController(MainController mainController) {
        this.mainController = mainController;
        viewItemIndex = 0;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
        this.equipment = inventory.getEquipment();
        inventoryIterator = inventory.getIterator();
        inventoryIterator.reset();
    }

    @Override
    public void handleEscape() {
        mainController.setActiveContext(GameContext.MENU);
    }


    @Override
    public void handleI() {
        mainController.setActiveContext(GameContext.AREA);
        viewItemIndex = 0;
        inventoryIterator.reset();
    }

    @Override
    public void handleEnter() {
        TakeableItem currentItem = inventoryIterator.getCurrent();
        equipment.equip(currentItem);
        System.out.println("Equipment has a " + equipment.getEquipped().getItemType());
        //mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.EQUIPMENT);
    }

    @Override
    public void handleNumpad(Direction direction) {

        switch(direction){
            case N:
                viewItemIndex -= InventorySizes.INVENTORY_COLUMNS;

                for(int shiftIndex = 0; shiftIndex < InventorySizes.INVENTORY_COLUMNS; shiftIndex++){
                    if(inventoryIterator.hasPrev()) {
                        inventoryIterator.prev();
                    }
                }

                if(viewItemIndex < 0){
                    viewItemIndex = 0;
                }
                mainController.getAreaViewPort().moveCursor(viewItemIndex);
                break;
            case E:
                viewItemIndex += 1;
                if(inventoryIterator.hasNext()){
                    inventoryIterator.next();
                }
                if(viewItemIndex > (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS)){
                    viewItemIndex = (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS);
                }
                mainController.getAreaViewPort().moveCursor(viewItemIndex);
                break;
            case W:
                viewItemIndex -= 1;
                if(inventoryIterator.hasPrev()){
                    inventoryIterator.prev();
                }

                if(viewItemIndex < 0){
                    viewItemIndex = 0;
                }
                mainController.getAreaViewPort().moveCursor(viewItemIndex);
                break;
            case S:
                viewItemIndex += InventorySizes.INVENTORY_COLUMNS;
                for(int shiftIndex = 0; shiftIndex < InventorySizes.INVENTORY_COLUMNS; shiftIndex++){
                    if(inventoryIterator.hasNext()) {
                        inventoryIterator.next();
                    }
                }
                if(viewItemIndex > (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS)){
                    viewItemIndex = (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS);
                }
                mainController.getAreaViewPort().moveCursor(viewItemIndex);
                break;
        }
    }
}
