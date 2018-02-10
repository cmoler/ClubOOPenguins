package Controller.Controller;

import Controller.Contexts.*;
import Controller.Input.Input;
import Controller.Game.OOPenguinGameFrame;


public class MainController {

    private OOPenguinGameFrame game;
    private Input input;

    private Context areaContext;
    private Context menuContext;
    private Context inventoryContext;
    private Context equipmentContext;

    private AreaController areaController;
    private MenuController menuController;
    private InventoryController inventoryController;
    private EquipmentController equipmentController;

    public MainController() {
        game = new OOPenguinGameFrame();

        areaController = new AreaController(this);
        menuController = new MenuController(this);
        inventoryController = new InventoryController(this);
        equipmentController = new EquipmentController(this);

        areaContext = new AreaContext(areaController);
        menuContext = new MenuContext(menuController);
        inventoryContext = new InventoryContext(inventoryController);
        equipmentContext = new EquipmentContext(equipmentController);

        input = new Input(menuContext);
        game.addKeyListener(input);
    }

    public void setActiveContext(GameContext context) {

        switch (context){
            case AREA:
                input.setActiveContext(areaContext);
                break;

            case INVENTORY:
                input.setActiveContext(inventoryContext);
                break;

            case EQUIPMENT:
                input.setActiveContext(equipmentContext);
                break;

            case MENU:
                input.setActiveContext(menuContext);
                break;

            default:
                input.setActiveContext(menuContext);
                break;
        }
    }


    public void gameLoop() {

    }


    public static void main(String[] args) {
        MainController mainController = new MainController();

        mainController.gameLoop();
    }
}
