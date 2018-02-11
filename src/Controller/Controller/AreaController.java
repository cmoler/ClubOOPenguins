package Controller.Controller;

import Controller.Contexts.GameContext;
import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.World;
import View.Viewport;

public class AreaController implements Controller {

    private MainController mainController;
    private Entity entity;
    private World world;
    private Viewport areaView;


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

    }

    @Override
    public void handleE() {

    }

    @Override
    public void handleNumpad(Direction direction){
        System.out.println("Moving" + direction + " ");
        //entity.move(direction);
    }
}