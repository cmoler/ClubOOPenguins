package Controller.Controller;

import Configs.SpriteParser;
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
    private int currentlySelected = 3;
    private int currentlySelectedAvatar = 0;
    private MapBuilder mapBuilder;
    private EntityBuilder entityBuilder;
    private boolean gameInitialized;



    public MenuController(MainController mainController){
        this.mainController = mainController;
        gameInitialized = false;

    }

    @Override
    public void handleEscape() {
        System.out.println("Command: close menu");
        if(gameInitialized){
            mainController.setActiveContext(GameContext.AREA);
        }
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

        case E:
            currentlySelectedAvatar = 1;
            mainController.setSelectedAvatarView(1);
        break;

        case W:
            currentlySelectedAvatar = 1;
            mainController.setSelectedAvatarView(0);
        break;

        case S:
            if(currentlySelected > 0) currentlySelected--;
            mainController.setSelectedMenuView(-1);
        break;
        }
    }

    public void saveGame() {
        GameSaver saver = new GameSaver();
        saver.SaveGame(mainController.getEntity());
    }

    public void loadGame() {
        GameLoader gameLoader = new GameLoader();
        try {
            gameLoader.loadGame();
            mainController.setAreaViewPort(gameLoader.getViewport());
            mainController.setEntity(gameLoader.getEntity());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mainController.setAreaRender();
        mainController.setActiveContext(GameContext.AREA);
    }

    public void startGame(){
        mapBuilder = new MapBuilder();
        entityBuilder = new EntityBuilder();

        MapView mapView1 = null;
        MapView mapView2 = null;
        MapView mapView3 = null;

        AvatarView avatarView1 = null;

        try {
            Map m1 = mapBuilder.buildMap("0001");
            mapView1 = mapBuilder.getViewport();

            Map m2 = mapBuilder.buildMap("0002");
            mapView2 = mapBuilder.getViewport();

            Map m3 = mapBuilder.buildMap("0003");
            mapView3 = mapBuilder.getViewport();


            World.getWorld().addMap("0001", m1, mapView1);
            World.getWorld().addMap("0002", m2, mapView2);
            World.getWorld().addMap("0003", m3, mapView3);
            World.getWorld().changeCurrentMapTo(m1);

            Entity e = entityBuilder.buildEntity("0001");
            avatarView1 = entityBuilder.getAvatarView();
            switch (currentlySelectedAvatar){
                case 0:
                    System.out.println("selected default");
                    avatarView1.setAvatarImage(SpriteParser.getSpriteParser().getAvatarImage());
                    break;

                case 1:
                    System.out.println("selected ninja");
                    avatarView1.setAvatarImage(SpriteParser.getSpriteParser().getAvatarImage_NINJA());
                    break;
            }


            mainController.setEntity(e);
            gameInitialized = true;
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