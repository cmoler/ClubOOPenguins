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

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
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
