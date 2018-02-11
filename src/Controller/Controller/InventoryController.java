package Controller.Controller;

import Configs.InventorySizes;
import Controller.Contexts.GameContext;
import Model.Map.Direction;
import View.StatusView.StatusViewPort;

public class InventoryController implements Controller {

    private MainController mainController;
    private int itemIndex;

    public InventoryController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {
        mainController.setActiveContext(GameContext.MENU);
    }


    @Override
    public void handleI() {
        mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.INVENTORY);

    }

    @Override
    public void handleEnter() {
        mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.EQUIPMENT);
    }

    @Override
    public void handleNumpad(Direction direction) {

        switch(direction){
            case N:
                itemIndex -= InventorySizes.INVENTORY_COLUMNS;
                if(itemIndex < 0){
                    itemIndex = 0;
                }
                mainController.getAreaViewPort().moveCursor(itemIndex);
                break;
            case W:
                itemIndex += 1;
                if(itemIndex > (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS)){
                    itemIndex = (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS);
                }
                mainController.getAreaViewPort().moveCursor(itemIndex);
                break;
            case E:
                itemIndex -= 1;
                if(itemIndex < 0){
                    itemIndex = 0;
                }
                mainController.getAreaViewPort().moveCursor(itemIndex);
                break;
            case S:
                itemIndex += InventorySizes.INVENTORY_COLUMNS;
                if(itemIndex > (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS)){
                    itemIndex = (InventorySizes.INVENTORY_COLUMNS  * InventorySizes.INVENTORY_ROWS);
                }
                mainController.getAreaViewPort().moveCursor(itemIndex);
                break;
        }
    }
}
