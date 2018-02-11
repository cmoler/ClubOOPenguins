package Controller.Controller;

import Controller.Utility.EntityBuilder;
import Controller.Utility.GameLoader;
import Controller.Utility.GameSaver;
import Controller.Utility.MapBuilder;
import Controller.Contexts.GameContext;
import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Map;
import Model.Map.World;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.StatusView.StatusViewPort;
import View.Viewport;

import java.io.FileNotFoundException;

public class MenuController implements Controller {

    private MainController mainController;
    private GameLoader gameLoader;
    private GameSaver gameSaver;
    private int currentlySelected = 3;
    private MapBuilder mapBuilder;
    private EntityBuilder entityBuilder;



    public MenuController(MainController mainController){
        this.mainController = mainController;


    }

    @Override
    public void handleEscape() {
        System.out.println("Command: close menu");
        mainController.setActiveContext(GameContext.AREA);

    }

    @Override
    public void handleI() {
        mainController.getAreaViewPort().setRenderOption(StatusViewPort.RenderOption.INVENTORY);

    }

    @Override
    public void handleE() {
        switch (currentlySelected){
            case 0:
                exitGame();
                break;
            case 1:
                loadGame();
                break;
            case 2:
                saveGame();
                break;
            case 3:
                startGame();
                break;
        }
    }

    private void exitGame() {
    }

    @Override
    public void handleNumpad(Direction direction) {
        switch (direction){
        case N:
            mainController.setSelectedMenuView(1);
            if(currentlySelected < 3) currentlySelected++;
        break;

        case S:
            if(currentlySelected > 0) currentlySelected--;
            mainController.setSelectedMenuView(-1);
        break;
        }
    }

    public void saveGame() {

    }

    public void loadGame() {

    }

    public void startGame(){
        mapBuilder = new MapBuilder();
        entityBuilder = new EntityBuilder();

        try {
            Map m1 = mapBuilder.buildMap("Default","0001");
            Map m2 = mapBuilder.buildMap("Default","0002");
            Map m3 = mapBuilder.buildMap("Default","0003");

            World.getWorld().addMap("0001", m1);
            World.getWorld().addMap("0002", m2);
            World.getWorld().addMap("0003", m3);
            World.getWorld().changeCurrentMapTo(m1);

            Entity e = entityBuilder.buildEntity("Default", "0001");
            mainController.setEntity(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MapView mapView = mapBuilder.getViewport();
        AvatarView avatarView = entityBuilder.getAvatarView();

        StatusViewPort statusViewPort = entityBuilder.getStatusViewport();
        statusViewPort.setRenderOption(StatusViewPort.RenderOption.INVENTORY);

        mapView.setEntity(avatarView.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView);
        viewport.add(statusViewPort);
        viewport.add(avatarView);

        mainController.setAreaViewPort(viewport);

        mainController.setAreaRender();
        mainController.setActiveContext(GameContext.AREA);

    }

}
