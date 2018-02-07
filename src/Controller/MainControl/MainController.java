package Controller.MainControl;

import Controller.Contexts.Context;
import Controller.Contexts.GameContext;
import Controller.Contexts.InventoryContext;
import Controller.Contexts.MenuContext;
import Controller.GameController.GameController;
import Controller.MainMenuControl.MainMenuController;
import View.Viewport;


public class MainController {

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
        inventoryContext = new InventoryContext(this);
        input = new Input(menuContext);
        game.addKeyListener(input);
    }


    public void setActiveContext(Context context) {
        System.out.println("Set Active context called with " + context.getClass().toString());
        input.setActiveContext(context);
    }

    public void openMenu() {
        System.out.println("Opening Menu");
        setActiveContext(menuContext);
    }

    public void closeMenu() {
        System.out.println("Closing Menu");
        setActiveContext(gameContext);
    }

    public void openInventory(){
        System.out.println("Opening Inventory");
        setActiveContext(inventoryContext);
    }

    public void closeInventory(){
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
