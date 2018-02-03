package Model.Map;

import Model.Entity.Direction;
import Model.Entity.Entity;
import Model.Item.Item;
import Model.Map.AreaEffect.AreaEffect;
import Model.Map.Terrain.Terrain;
import View.Viewport;

import java.util.List;

public class Location {

    private Terrain terrain;
    private boolean obstacle;
    private List<Location> adjacentLocations;
    private AreaEffect areaEffect;
    private List<Item> items;

    public Location getAdjacentAt(Direction direction){
        return null;
    }

    public AreaEffect getAreaEffect() {
        return areaEffect;
    }

    public boolean moveAllowed(Entity entity){
        return false;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
