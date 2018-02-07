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
    private int cordX;
    private int cordY;
    private int width;
    private int height;

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

    public int getX(){
        return cordX;
    }

    public int getY(){
        return cordY;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
