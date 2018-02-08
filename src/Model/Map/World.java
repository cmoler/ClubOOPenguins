package Model.Map;

import Controller.MainMenuControl.MapBuilder;
import View.Viewport;

import java.util.HashMap;
import java.util.List;

public class World {

    public static World instance = null;

    private Map currentMap;
    private HashMap<String,Map> maps;

    protected World(){
        // Can't instantiate
    }

    public static World getWorld(){
        if (instance == null)
        {
            instance = new World();
        }
        return instance;
    }

    public void changeCurrentMapTo(Map map){
        currentMap = map;
    }

    public void addMap(String mapID, Map map){
        maps.put(mapID, map);
    }

    public Map getMap(String mapID){
        return maps.get(mapID);
    }

    public void buildMap(MapBuilder mapBuilder){

    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
