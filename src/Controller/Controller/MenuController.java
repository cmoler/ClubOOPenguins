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

    }

    @Override
    public void handleT() {

    }

    @Override
    public void handleEnter() {
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
        System.exit(0);
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

        MapView mapView1 = null;
        MapView mapView2 = null;
        MapView mapView3 = null;

        AvatarView avatarView1 = null;
        AvatarView avatarView2 = null;
        AvatarView avatarView3 = null;

        try {
            Map m1 = mapBuilder.buildMap("Default","0001");
            mapView1 = mapBuilder.getViewport();

            Map m2 = mapBuilder.buildMap("Default","0002");
            mapView2 = mapBuilder.getViewport();

            Map m3 = mapBuilder.buildMap("Default","0003");
            mapView3 = mapBuilder.getViewport();


            World.getWorld().addMap("0001", m1, mapView1);
            World.getWorld().addMap("0002", m2, mapView2);
            World.getWorld().addMap("0003", m3, mapView3);
            World.getWorld().changeCurrentMapTo(m1);

            Entity e = entityBuilder.buildEntity("Default", "0001");
            avatarView1 = entityBuilder.getAvatarView();
            mainController.setEntity(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StatusViewPort statusViewPort = entityBuilder.getStatusViewport();

        mapView1.setEntity(avatarView1.getEntity());
        mapView2.setEntity(avatarView1.getEntity());
        mapView3.setEntity(avatarView1.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView1);
        viewport.add(statusViewPort);
        viewport.add(avatarView1);

        World.getWorld().setViewport(viewport);

        mainController.setAreaViewPort(viewport);

        mainController.setAreaRender();
        mainController.setActiveContext(GameContext.AREA);

    }

}