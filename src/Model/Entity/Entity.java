package Model.Entity;

import Model.Map.Location;
import Model.Map.Map;
import View.Viewport;

import java.util.Collections;
import java.util.HashMap;

public class Entity {

    private int health = 100; // default health?
    private int experience = 0;
    private int level = 1; // default level
    private Inventory inventory = new Inventory();
    private EntityType entityType;
    private Location location;
    private Map map;

    // TODO: should there be a default location and map?
    public Entity() {
        entityType = EntityType.ICE; // default EntityType
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

    public void teleport(Location location, Map map){
        this.map = map;
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

    public Map getMap(){
        return map;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
    }

    public int getX(){
        return location.getX();
    }

    public int getY(){
        return location.getY();
    }

    public int getWidth(){
        return location.getWidth();
    }

    public int getHeight(){
        return location.getHeight();
    }

    // setters
    // use case: setting Entity's map at the beginning of game
    public void setMap(Map map) {
        this.map = map;
        // this.location = map.middle // default location?
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

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