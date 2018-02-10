package Model.Map;

import Model.Entity.Entity;
import Model.Item.Item;
import Model.Map.AreaEffect.AreaEffect;
import Model.Map.Terrain.Terrain;
import View.Viewport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Location {

    private Terrain terrain;
    private boolean obstacle;
    private HashMap<Direction, Location> adjacentLocations;
    private AreaEffect areaEffect;
    private List<Item> items;
    private List<Viewport> observers = new ArrayList<Viewport>();

    public Location(Terrain terrain, boolean obstacle, AreaEffect areaEffect, List<Item> items){
        this.terrain = terrain;
        this.obstacle = obstacle;
        this.areaEffect = areaEffect;
        if (this.areaEffect != null)
            this.areaEffect.setLocation(this);
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

    public Terrain getTerrain() {
        return terrain;
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
