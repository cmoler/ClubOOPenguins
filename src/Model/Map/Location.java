package Model.Map;

import Model.Entity.Direction;
import Model.Entity.Entity;
import Model.Item.Item;
import Model.Map.AreaEffect.AreaEffect;
import Model.Map.Terrain.Terrain;
import View.Viewport;

import java.util.HashMap;
import java.util.List;

public class Location {

    private Terrain terrain;
    private boolean obstacle;
    private HashMap<Direction, Location> adjacentLocations;
    private AreaEffect areaEffect;
    private List<Item> items;


    public void Location(Terrain terrain, boolean obstacle, AreaEffect areaEffect, List<Item> items){
        this.terrain = terrain;
        this.obstacle = obstacle;
        this.areaEffect = areaEffect;
        this.items = items;
    }

    public void setAdjacentLocations(HashMap<Direction, Location> adjacentLocations)
    {
        this.adjacentLocations = adjacentLocations;
    }

    public Location getAdjacentAt(Direction direction){
        return adjacentLocations.get(direction);
    }

    public AreaEffect getAreaEffect() {
        return areaEffect;
    }

    public boolean moveAllowed(Entity entity){
        if (!obstacle && terrain.enter(entity.getEntityType()))
        {
            return true;
        }
        return false;
    }

    public List<Item> getItems(){
        return items;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
