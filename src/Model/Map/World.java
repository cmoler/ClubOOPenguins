package Model.Map;

import Controller.Utility.MapBuilder;
import View.Viewport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {

    private List<Viewport> observers = new ArrayList<Viewport>();

    public static World instance = null;
    private Map currentMap;
    private HashMap<String,Map> maps = new HashMap<String,Map>();

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
        notifyView();
    }

    public Map getCurrentMap(){
        return currentMap;
    }

    public void addMap(String mapID, Map map){
        maps.put(mapID, map);
    }

    public String getMapID(Map map) {
      return maps.get(map);
    }

    public Map getMap(String mapID){
        return maps.get(mapID);
    }

    public void buildMap(MapBuilder mapBuilder){

    }

    public void attach(Viewport viewport){
        observers.add(viewport);
    }

    public void detach(Viewport viewport){
        observers.remove(viewport);
    }

    public void notifyView(){
        for (Viewport viewport : observers){
            viewport.update();
        }
    }
}
