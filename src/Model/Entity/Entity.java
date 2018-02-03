package Model.Entity;

import Model.Map.Location;
import Model.Map.Map;
import View.Viewport;

public class Entity {

    private int health;
    private int experience;
    private Inventory inventory;
    private EntityType entityType;
    private Location location;
    private Map map;

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public void gainExperience(int experience){

    }

    public boolean canLevelUp(){
        return true;
    }

    public void heal(){

    }

    public EntityType getEntityType(){
        return entityType;
    }

    public Map getMap(){
        return map;
    }

    public void teleport(Location location, Map map){

    }

    public void move(Direction direction){

    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
