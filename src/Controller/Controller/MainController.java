package Controller.Controller;

import Controller.Contexts.*;
import Controller.Input.Input;
import Controller.Game.OOPenguinGameFrame;
import View.MenuView.MenuViewPort;
import Controller.Utility.EntityBuilder;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.StatusView.StatusViewPort;
import View.Viewport;


public class MainController {

    private OOPenguinGameFrame game;
    private Input input;

    private EntityBuilder entityBuilder;

    private Context areaContext;
    private Context menuContext;
    private Context inventoryContext;
    private Context equipmentContext;

    private AreaController areaController;
    private MenuController menuController;
    private InventoryController inventoryController;
    private EquipmentController equipmentController;

    private Viewport viewport;

    public MainController() {
        MenuViewPort menuViewPort = new MenuViewPort();
        game = new OOPenguinGameFrame();
        game.add(menuViewPort);
        menuViewPort.setVisible(true);
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

    private void initGame(){

    }

    public void setViewPort(Viewport viewPort){
        this.viewport = viewPort;
    }

    public Viewport getViewPort(){
        return this.viewport;
    }

    public Viewport getStatusViewPort(){
        return viewport.getChildren().get(2).getChildren().get(0);
    }



    public void gameLoop() {

    }
}
