package Controller.MainControl;

import Controller.Contexts.Context;
import Controller.Contexts.MenuContext;
import Controller.GameController.GameController;
import Controller.MainMenuControl.MainMenuController;
import View.Viewport;

public class MainController {

    private Input input;
    private Context activeContext;
    private OOPenguinGame game;

    private Viewport viewport;
    private GameController gameController;
    private MainMenuController mainMenuController;

    private boolean gameRunning = true;

    public MainController() {
        game = new OOPenguinGame();
        activeContext = new MenuContext();
        input = new Input(activeContext);
        game.addKeyListener(input);
    }

    private void setContext(Context context) {

    }

    public void gameLoop() {

    }


    public static void main(String[] args) {
        MainController mainController = new MainController();

        mainController.gameLoop();
    }
}
