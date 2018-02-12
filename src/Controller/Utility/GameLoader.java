package Controller.Utility;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Terrain.Ice;
import Model.Map.World;
import View.AreaView.AreaViewPort;
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
    private MapView mapView;
    private AvatarView avatarView;
    private StatusViewPort statusViewPort;

    public void loadGame() throws FileNotFoundException {
        MapBuilder mapBuilder = new MapBuilder();
        EntityBuilder entityBuilder = new EntityBuilder();

        GameSaver saver = new GameSaver();

        Map map = new Map(6, 5);
        Entity ent = new Entity(new Location(new Ice(), false, null, null));

        File mapDir = new File("resources/maps_save");
        File[] listOfFiles = mapDir.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    if (listOfFiles[i].getName().substring(8, 12).equals("0001")) {
                        map = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), map, mb.getViewport());
                        World.getWorld().changeCurrentMapTo(map);
                        mapView = mb.getViewport();
                        System.out.println("Built map: " + listOfFiles[i].getName().substring(8, 12));

//                    entityBuilder.buildEntity("0001");

                        File entDir = new File("resources/entities_save");
                        File[] listOfEnt = entDir.listFiles();
                        if(listOfEnt != null) {
                            for (int j = 0; j < listOfEnt.length; j++) {
                                if (listOfEnt[j].isFile()) {
                                    System.out.println("Built entity: " + listOfEnt[j].getName().substring(11, 15));
                                    if (listOfEnt[j].getName().substring(11, 15).equals("0001")){
                                        entity = eb.buildEntity(listOfEnt[j].getName().substring(11, 15));
                                        avatarView = eb.getAvatarView();
                                        mb.getViewport().setEntity(avatarView.getEntity());
                                        statusViewPort = eb.getStatusViewport();

                                    }
                                }
                            }
                        }
//                        viewport.add(mv);
//                        viewport.add(statusViewPort);
//                        viewport.add(avatarView);
//                        World.getWorld().setViewport(viewport);
                    } else {
                        Map mp = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), mp, mb.getViewport());
                        System.out.println("Built map: " + listOfFiles[i].getName().substring(8, 12));
                    }

                }
            }
        }

    }

    public Entity getEntity(){
        return entity;
    }

    public AvatarView getAvatarView(){
        return avatarView;
    }

    public StatusViewPort getStatusViewPort(){
        return statusViewPort;
    }

    public MapView getMapView(){
        return mapView;
    }
}
