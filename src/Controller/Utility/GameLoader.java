package Controller.Utility;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Terrain.Ice;
import Model.Map.World;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.StatusView.StatusViewPort;
import View.Viewport;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameLoader {

    private String saveFileLocation;
    private Viewport viewport = new Viewport();
    private Entity entity;

    public void loadGame() throws FileNotFoundException {
        MapBuilder mapBuilder = new MapBuilder();
        EntityBuilder entityBuilder = new EntityBuilder();

        File mapDir = new File("resources/maps_save");
        File[] listOfFiles = mapDir.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName().substring(8, 12));
                    if (listOfFiles[i].getName().substring(8, 12).equals("0001")) {
                        StatusViewPort statusViewPort = null;
                        AvatarView avatarView = null;

                        Map map = mapBuilder.buildMap(listOfFiles[i].getName().substring(8, 12));
                        MapView mapView = mapBuilder.getViewport();
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), map, mapView);
                        World.getWorld().changeCurrentMapTo(map);

                        File entDir = new File("resources/entities_save");
                        File[] listOfEnt = entDir.listFiles();
                        if(listOfEnt != null) {
                            for (int j = 0; j < listOfEnt.length; j++) {
                                if (listOfEnt[j].isFile()) {
                                    System.out.println("Entity: " + listOfEnt[j].getName().substring(11, 15));
                                    if (listOfEnt[j].getName().substring(11, 15).equals("0001")) {
                                        entity = entityBuilder.buildEntity(listOfEnt[j].getName().substring(11, 15));
                                        avatarView = entityBuilder.getAvatarView();
                                        statusViewPort = entityBuilder.getStatusViewport();
                                        mapView.setEntity(avatarView.getEntity());
                                    }
                                }
                            }
                        }
                        viewport.add(mapView);
                        viewport.add(statusViewPort);
                        viewport.add(avatarView);
                        World.getWorld().setViewport(viewport);
                    } else {
                        Map map = mapBuilder.buildMap(listOfFiles[i].getName().substring(8, 12));
                        MapView mapView = mapBuilder.getViewport();
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), map, mapView);
                        System.out.println("memes");
                    }

                }
            }
        }
    }

    public Entity getEntity(){
        return entity;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
