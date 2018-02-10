package Controller.Controller;

import Controller.Utility.GameLoader;
import Controller.Utility.GameSaver;
import Model.Entity.Entity;
import Controller.Contexts.GameContext;
import Model.Map.Direction;

public class MenuController implements Controller {

    private MainController mainController;
    private GameLoader gameLoader;
    private GameSaver gameSaver;
    private int currentlySelected;

    public MenuController(MainController mainController){
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {
        System.out.println("Command: close menu");
        mainController.setActiveContext(GameContext.AREA);
    }

    @Override
    public void handleI() {

    }

    @Override
    public void handleE() {

    }

    public void handleNumpad(Direction direction) {

    }

    public void saveGame(String filepath, Entity entity) {

    }

    public void loadGame(String filepath) {

    }

    public void newGame(){

    }

}
