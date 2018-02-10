package Controller.Contexts;

import Controller.Controller.Controller;
import Controller.Controller.GameController;

import java.awt.event.KeyEvent;

public class GameContext extends Context{

    private GameController gameController;

    public GameContext(GameController gameController){
        this.gameController = gameController;
    }

    public Controller getController() {
        return gameController;
    }

    public void processKeyEvent(KeyEvent event) {

    }
}