package Model.Map;

import Controller.Utility.MapBuilder;
import View.Viewport;
import java.util.List;

public class World {

    public static World instance = null;

    private Map currentMap;
    private List<Map> maps;

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

    public void buildMap(MapBuilder mapBuilder){

    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
