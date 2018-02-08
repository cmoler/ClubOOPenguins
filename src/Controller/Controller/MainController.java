package Controller.Controller;

import Controller.Contexts.Context;
import Controller.Contexts.GameContext;
import Controller.Contexts.EquipmentContext;
import Controller.Contexts.MenuContext;
import Controller.Input.Input;
import Controller.Game.OOPenguinGame;

import View.Viewport;


public class MainController extends Controller {

    private Input input;
    private Context gameContext;
    private Context menuContext;
    private Context inventoryContext;
    private OOPenguinGame game;

    private Viewport viewport;
    private GameController gameController;
    private MainMenuController mainMenuController;

    private boolean gameRunning = true;

    public MainController() {
        game = new OOPenguinGame();
        gameContext = new GameContext(this);
        menuContext = new MenuContext(this);
        inventoryContext = new EquipmentContext(this);
        input = new Input(menuContext);
        game.addKeyListener(input);
    }

    private void setActiveContext(Context context) {
        input.setActiveContext(context);
        //make visible whatever you're setting
    }

    public void openMenu() {
        System.out.println("Opening Menu");
        setActiveContext(menuContext);
    }

    public void closeMenu() {
        System.out.println("Closing Menu");
        setActiveContext(gameContext);
    }

    public void openInventory() {
        System.out.println("Opening Inventory");
        setActiveContext(inventoryContext);
    }

    public void closeInventory() {
        System.out.println("Closing Inventory");
        setActiveContext(gameContext);
    }


    public void gameLoop() {

    }


    public static void main(String[] args) {
        MainController mainController = new MainController();

        mainController.gameLoop();
    }
}
