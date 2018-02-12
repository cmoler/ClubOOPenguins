package Controller.Utility;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Terrain.Ice;
import Model.Map.World;
import View.AreaView.MapView;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameLoader {

    private String saveFileLocation;
    private World world;
    private Entity entity;

    public void loadGame() throws FileNotFoundException {
        MapBuilder mb = new MapBuilder();
        EntityBuilder eb = new EntityBuilder();

        GameSaver gs = new GameSaver();

        Map map = new Map(6, 5);
        MapView mv = new MapView();
        Entity ent = new Entity(new Location(new Ice(), false, null, null));

        File mapDir = new File("resources/maps_saves");
        File[] listOfFiles = mapDir.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName().substring(8, 12));
                    if (listOfFiles[i].getName().substring(8, 12).equals("0001")) {
                        map = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), map, mv);
                        World.getWorld().changeCurrentMapTo(map);

//                    eb.buildEntity("0001");

                        File entDir = new File("resources/entities_saves");
                        File[] listOfEnt = entDir.listFiles();
                        if(listOfEnt != null) {
                            for (int j = 0; j < listOfEnt.length; j++) {
                                if (listOfEnt[j].isFile()) {
                                    System.out.println("Entity: " + listOfEnt[j].getName().substring(11, 15));
                                    if (listOfEnt[j].getName().substring(11, 15).equals("0001"))
                                        ent = eb.buildEntity(listOfEnt[j].getName().substring(11, 15));
                                }
                            }
                        }

                    } else {
                        Map mp = mb.buildMap(listOfFiles[i].getName().substring(8, 12));
                        World.getWorld().addMap(listOfFiles[i].getName().substring(8, 12), mp, mv);
                        System.out.println("memes");
                    }

                }
            }
        }

        gs.SaveGame(ent);

    }

    public Entity getEntity(){
        return entity;
    }
}
