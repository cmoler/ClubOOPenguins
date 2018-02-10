package Controller.Controller;

import Controller.Contexts.*;
import Controller.Input.Input;
import Controller.Game.OOPenguinGameFrame;


public class MainController {

    private OOPenguinGameFrame game;
    private Input input;

    private Context gameContext;
    private Context menuContext;
    private Context inventoryContext;
    private Context equipmentContext;

    private GameController gameController;
    private MenuController menuController;
    private InventoryController inventoryController;
    private EquipmentController equipmentController;

    public MainController() {
        game = new OOPenguinGameFrame();


        gameController = new GameController(this);
        menuController = new MenuController(this);
        inventoryController = new InventoryController(this);
        equipmentController = new EquipmentController(this);

        gameContext = new GameContext(gameController);
        menuContext = new MenuContext(menuController);
        inventoryContext = new InventoryContext(inventoryController);
        equipmentContext = new EquipmentContext(equipmentController);

        input = new Input(menuContext);
        game.addKeyListener(input);
    }

    private void setActiveContext(Context context) {
        input.setActiveContext(context);

    }


    public void gameLoop() {

    }


    public static void main(String[] args) {
        MainController mainController = new MainController();

        mainController.gameLoop();
    }
}
