package Controller.Controller;

import Controller.Utility.GameLoader;
import Controller.Utility.GameSaver;
import Model.Entity.Entity;

public class MenuController extends Controller {

    private MainController mainController;
    private GameLoader gameLoader;
    private GameSaver gameSaver;

    public MenuController(MainController mainController){
        this.mainController = mainController;
    }

    public void saveGame(String filepath, Entity entity){

    }

    public void loadGame(String filepath){

    }

    public void newGame(){

    }

    @Override
    public void handleEscape() {

    }

    @Override
    public void handleNorth() {

    }

    @Override
    public void handleSouth() {

    }

    @Override
    public void handleWest() {

    }

    @Override
    public void handleEast() {

    }

    @Override
    public void handleNorthEast() {

    }

    @Override
    public void handleNorthWest() {

    }

    @Override
    public void handleSouthEast() {

    }

    @Override
    public void handleSouthWest() {

    }
}
