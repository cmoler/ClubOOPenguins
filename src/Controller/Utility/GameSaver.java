package Controller.Utility;

import Model.Entity.Entity;
import Model.Map.World;
import View.Viewport;

public class GameSaver {

    private String saveFileLocation;

    public void static String getTileData() {
        String tile = " ";

        //Switch statement over all tile types

//        switch()
    }

    public void SaveGame(String saveFileLocation, Entity entity, World world, Viewport viewport){
        String worldData = "";
        String entityData = "";

        //A getTile function in the viewport or the model could let us iterate over all the map tiles to save the world map
        //Not sure this is the best solution, but should work for the map

        for(int i = 0; i < viewport.getX(); i++) {
            for (int j = 0; i < viewport.getY(); j++) {
                worldData += getTileData(viewport.getTile(i, j));
            }
        }

        //Entity could be saved to a JSON file
    }
}
