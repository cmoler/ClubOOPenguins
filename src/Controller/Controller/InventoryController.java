package Controller.Controller;

import Controller.Contexts.GameContext;
import Model.Map.Direction;

public class InventoryController implements Controller {

    private MainController mainController;

    public InventoryController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {
        mainController.setActiveContext(GameContext.MENU);
    }

    @Override
    public void handleI() {

    }

    @Override
    public void handleE() {

    }

    @Override
    public void handleNumpad(Direction direction) {

    }
}
