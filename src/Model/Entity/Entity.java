package Model.Entity;

import Model.Map.Location;
import Model.Map.Map;
import Model.Map.World;
import View.Viewport;
import javafx.beans.Observable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Entity{

    private List<Viewport> observers;

    private int x;
    private int y;
    private int velocity = 5;

    private int health = 100; // default health?
    private int experience = 0;
    private int level = 1; // default level
    private Inventory inventory = new Inventory();
    private EntityType entityType;
    private Location location;
    // map is in World

    // TODO: should there be a default location and map?
    public Entity() {
        entityType = EntityType.ICE; // default EntityType
//        location = World... .center ?
    }

    public Entity(EntityType type){
        entityType = type;
    }

    public EntityType getEntityType(){
        return entityType;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDamage(int damage){
        health -= damage;
        if (health < 0)
            health = 0;
    }

    public void heal(int healing){
        health += healing;
        if (health > 100)
            health = 100;
    }

    public void gainExperience(int experience){
        this.experience += experience;
    }

    public boolean canLevelUp(){
        if (level < finalLevel) {
            if (experience > ExperienceForLevel.get(level + 1))
                return true;
            else
                return false;
        }
        else
            return false;
    }


    public void move(Direction direction){
        switch(direction){
            case N:
                y += velocity;
                break;
            case NE:
                y += velocity/2;
                x += velocity/2;
                break;
            case E:
                x += velocity;
                break;
            case SE:
                y -= velocity/2;
                x += velocity;
                break;
            case S:
                y -= velocity;
                break;
            case SW:
                y -= velocity/2;
                x -= velocity/2;
                break;
            case W:
                x -= velocity;
                break;
            case NW:
                y += velocity/2;
                x -= velocity/2;
                break;
        }

        int locationLeft = location.getX() * location.getWidth();
        int locationRight = (location.getX() + 1) * location.getWidth();
        int locationTop = location.getY() * location.getHeight();
        int locationBottom = (location.getY() + 1) * location.getHeight();

        if(locationLeft < x && x < locationRight){
            if(y > locationTop) moveToLocation(Direction.N);
            else if(y < locationBottom) moveToLocation(Direction.S);
        }
        else if(locationBottom < y && y < locationTop){
            if(x > locationRight) moveToLocation(Direction.E);
            else if(x < locationLeft) moveToLocation(Direction.W);
        }
        else if(x < locationLeft){
            if(y > locationTop) moveToLocation(Direction.NW);
            else if( y < locationTop) moveToLocation(Direction.SW);
        }
        else if(locationRight < x){
            if(y > locationTop) moveToLocation(Direction.NE);
            else if( y < locationTop) moveToLocation(Direction.SE);
        }
    }

    private void moveToLocation(Direction direction){
        if(location.getAdjacentAt(direction) == null) // if trying to move off edge of map
            return;
        Location nextLocation = location.getAdjacentAt(direction);
        if (nextLocation.moveAllowed(this)){
            this.location = nextLocation;
            if (this.location.getAreaEffect() != null){
                this.location.getAreaEffect().activate(this);
            }
        }
    }

    public void teleport(Location location){
        this.location = location;
    }

    // getters
    public int getHealth(){
        return health;
    }

    public int getExperience(){
        return experience;
    }

    public int getLevel(){
        return level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return location.getWidth();
    }

    public int getHeight(){
        return location.getHeight();
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

    private static final int finalLevel = 100;
    private static final java.util.Map<Integer, Integer> ExperienceForLevel; // <Level,Experience required for level>
    static {
        java.util.Map<Integer, Integer> modifiableMap = new HashMap<Integer, Integer>();

        int experienceInterval = 100; // if every level requires the same experience interval
        int experienceNeeded = 0;
        for(int level=1; level<=finalLevel; level++) {
            modifiableMap.put(level, experienceNeeded);
            experienceNeeded += experienceInterval;
        }

        ExperienceForLevel = Collections.unmodifiableMap(modifiableMap);
    }

}