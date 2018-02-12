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
        MapBuilder mb = new MapBuilder();
        EntityBuilder eb = new EntityBuilder();

        GameSaver gs = new GameSaver();

        Map map;
        MapView mv;
        AvatarView avatarView = null;
        StatusViewPort statusViewPort = null;

        File mapDir = new File("resources/maps_save");
        File[] listOfFiles = mapDir.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName().substring(8, 12));
                    if (listOfFiles[i].getName().substring(8, 12).equals("0001")) {
                        map = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        mv = mb.getViewport();
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), map, mv);
                        World.getWorld().changeCurrentMapTo(map);

//                    eb.buildEntity("0001");

                        File entDir = new File("resources/entities_save");
                        File[] listOfEnt = entDir.listFiles();
                        if(listOfEnt != null) {
                            for (int j = 0; j < listOfEnt.length; j++) {
                                if (listOfEnt[j].isFile()) {
                                    System.out.println("Entity: " + listOfEnt[j].getName().substring(11, 15));
                                    if (listOfEnt[j].getName().substring(11, 15).equals("0001")) {
                                        entity = eb.buildEntity(listOfEnt[j].getName().substring(11, 15));
                                        avatarView = eb.getAvatarView();
                                        statusViewPort = eb.getStatusViewport();
                                        mv.setEntity(entity);
                                    }
                                }
                            }
                        }
                        viewport.add(mv);
                        viewport.add(statusViewPort);
                        viewport.add(avatarView);
                        World.getWorld().setViewport(viewport);
                    } else {
                        Map mp = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        MapView mv2 = mb.getViewport();
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), mp, mv2);
                        System.out.println("memes");
                    }

                }
            }
        }

        gs.SaveGame(entity);

    }

    public Entity getEntity(){
        return entity;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
