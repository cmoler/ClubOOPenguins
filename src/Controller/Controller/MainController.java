package Controller.Controller;

import Controller.Contexts.*;
import Controller.Input.Input;
import Controller.Game.OOPenguinGameFrame;
import Model.Entity.Entity;
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

    public void setAreaViewPort(Viewport viewPort){
        this.areaViewport = viewPort;
        game.add(areaViewport);
        viewPort.addKeyListener(input);
        areaViewport.setVisible(false);
    }

    public Viewport getAreaViewPort(){
        return this.areaViewport;
    }

    public Viewport getStatusViewPort(){
        return areaViewport.getChildren().get(2).getChildren().get(0);
    }

    public void setSelectedMenuView(int i) {
        menuViewPort.setSelectedMenuView(i);
    }

    public void gameLoop() {

    }

    public void setMenuRender() {
        areaViewport.setVisible(false);
        menuViewPort.setVisible(true);
    }

    public void setAreaRender(){
        menuViewPort.setVisible(false);
        areaViewport.setVisible(true);
    }

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
