package Controller.Controller;

import Controller.Contexts.*;
import Controller.Input.Input;
import Controller.Game.OOPenguinGameFrame;
import Model.Entity.Entity;
import Model.Entity.Inventory;
import Model.Map.Direction;
import View.MenuView.MenuViewPort;
import Controller.Utility.EntityBuilder;
import View.Viewport;

public class MainController {

    private OOPenguinGameFrame game;
    private Input input;

    private Entity entity;

    private Context areaContext;
    private Context menuContext;
    private Context inventoryContext;
    private Context equipmentContext;

    private AreaController areaController;
    private MenuController menuController;
    private InventoryController inventoryController;
    private EquipmentController equipmentController;

    private Viewport areaViewport;
    private MenuViewPort menuViewPort;

    public MainController() {
        menuViewPort = new MenuViewPort();
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

        menuViewPort.addKeyListener(input);
        game.addKeyListener(input);
    }

    public void setActiveContext(GameContext context) {

        switch (context){
            case AREA:
                setAreaRender();
                input.setActiveContext(areaContext);
                areaViewport.requestFocus();
                break;

            case INVENTORY:
                setAreaRender();
                input.setActiveContext(inventoryContext);
                break;

            case EQUIPMENT:
                setAreaRender();
                input.setActiveContext(equipmentContext);
                break;

            case MENU:
                setMenuRender();
                input.setActiveContext(menuContext);
                menuViewPort.requestFocus();
                break;

            default:
                setMenuRender();
                input.setActiveContext(menuContext);
                break;
        }
    }

    private void initGame(){

    }

    public void setAreaViewPort(Viewport viewPort){
        this.areaViewport = viewPort;
        game.add(areaViewport);
        viewPort.addKeyListener(input);
    }

    public Viewport getAreaViewPort(){
        return this.areaViewport;
    }


    public void setSelectedMenuView(int i) {
        menuViewPort.setSelectedMenuView(i);
    }

    public void gameLoop() {
    }

    public void setMenuRender() {
        menuViewPort.setVisible(true);
        areaViewport.setVisible(false);
    }

    public void setAreaRender(){
        areaViewport.setVisible(true);
        menuViewPort.setVisible(false);
    }

    public void moveEntity(Direction direction){
        entity.move(direction);
    }

    public void setEntity(Entity entity){
        this.entity = entity;
        inventoryController.setInventory(entity.getInventory());
    }

    public Entity getEntity() {
        return entity;
    }
}
