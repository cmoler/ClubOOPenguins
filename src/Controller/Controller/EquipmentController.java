package Controller.Controller;

import Controller.Contexts.GameContext;
import Model.Map.Direction;
import View.StatusView.StatusViewPort;

public class EquipmentController implements Controller {

    private MainController mainController;


    public EquipmentController(MainController mainController){
        this.mainController = mainController;
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

    }

    @Override
    public void handleNumpad(Direction direction) {
        //does nothing now
    }

}