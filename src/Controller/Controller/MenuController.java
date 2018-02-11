package Controller.Controller;

import Controller.Utility.EntityBuilder;
import Controller.Utility.GameLoader;
import Controller.Utility.GameSaver;
import Controller.Utility.MapBuilder;
import Model.Entity.Entity;
import Controller.Contexts.GameContext;
import Model.Map.Direction;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.StatusView.StatusViewPort;
import View.Viewport;

import java.io.FileNotFoundException;

import static Model.Map.Direction.S;

public class MenuController implements Controller {

    private MainController mainController;
    private GameLoader gameLoader;
    private GameSaver gameSaver;
    private int currentlySelected;
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
        mainController.getViewPort().setRenderOption(StatusViewPort.RenderOption.INVENTORY);

    }

    @Override
    public void handleE() {
        mainController.getViewPort().setRenderOption(StatusViewPort.RenderOption.EQUIPMENT);
    }

    @Override
    public void handleNumpad(Direction direction) {
        switch (direction){
        case N:
            mainController.setSelectedMenuView(1);
        break;

        case S:
            mainController.setSelectedMenuView(-1);
        break;
        }
    }

    public void saveGame(String filepath, Entity entity) {

    }

    public void loadGame(String filepath) {

    }

    public void startGame(){
        mapBuilder = new MapBuilder();
        try {
            mapBuilder.buildMap("Default", "0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MapView mapView = mapBuilder.getViewport();

        entityBuilder = new EntityBuilder();
        try {
            entityBuilder.buildEntity("Default", "0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        AvatarView avatarView = entityBuilder.getAvatarView();

        StatusViewPort statusViewPort = entityBuilder.getStatusViewport();
        statusViewPort.setRenderOption(StatusViewPort.RenderOption.INVENTORY);

        mapView.setEntity(avatarView.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView);
        viewport.add(avatarView);
        viewport.add(statusViewPort);

        mainController.setViewPort(viewport);


    }

}
