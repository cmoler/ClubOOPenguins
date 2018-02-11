package Controller.Controller;

import Controller.Contexts.GameContext;
import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.World;
import View.StatusView.StatusViewPort;
import View.Viewport;

public class AreaController implements Controller {

    private MainController mainController;

    public AreaController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {
        mainController.setActiveContext(GameContext.MENU);
        mainController.setMenuRender();
    }

    @Override
    public void handleI() {
        mainController.setActiveContext(GameContext.INVENTORY);
        mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.INVENTORY);
    }

    @Override
    public void handleT() {
        mainController.setActiveContext(GameContext.EQUIPMENT);
        mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.EQUIPMENT);
    }

    @Override
    public void handleEnter() {

    }

    @Override
    public void handleNumpad(Direction direction){
        System.out.println("Moving" + direction + " ");
        mainController.moveEntity(direction);
    }
}