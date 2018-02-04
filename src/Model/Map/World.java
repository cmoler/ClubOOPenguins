package Model.Map;

import Controller.MainMenuControl.MapBuilder;
import View.Viewport;

import java.util.List;

public class World {

    private Map currentMap;
    private List<Map> maps;

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
