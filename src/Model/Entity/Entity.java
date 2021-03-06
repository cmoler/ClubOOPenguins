package Model.Entity;

import Model.Item.Item;
import Model.Item.TakeableItem;
import Model.Map.Direction;
import Model.Map.Location;
import View.Viewport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Entity{

    private List<Viewport> observers = new ArrayList<Viewport>();

    private int velocity = 5;

    private int maxHealth = 100;
    private int health = maxHealth; // default health?
    private int experience = 0;
    private int level = 1; // default level
    private Inventory inventory = new Inventory(this);
    private EntityType entityType;
    private Location location;
    // map is in World

    //Entity for testing purposes
    public Entity(){
        entityType = EntityType.ICE;
        location = null;
    }

    public Entity(Location initialLocation) {
        entityType = EntityType.ICE; // default EntityType
        location = initialLocation;
    }

    public Entity(EntityType type, Location initialLocation){
        entityType = type;
        location = initialLocation;
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
        notifyView();
    }

    public void heal(int healing){
        health += healing;
        if (health > maxHealth)
            health = maxHealth;
        notifyView();
    }

    public void gainExperience(int experience){
        this.experience += experience;
        while (canLevelUp())
            level++;
        notifyView();
    }

    public void modifyMaxHealth(int health){
        maxHealth += health;
        if (this.health > maxHealth)
        {
            this.health = maxHealth;
        }

    }

    // don't think this needs to be public
    private boolean canLevelUp(){
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
        if (isAlive()){
            if(location.getAdjacentAt(direction) == null) // if trying to move off edge of map
                return;
            Location nextLocation = location.getAdjacentAt(direction);
            if (nextLocation.moveAllowed(this)){
                this.location = nextLocation;
                if (this.location.getAreaEffect() != null){
                    this.location.getAreaEffect().activate(this);
                }
                Location.LocationItemIterator locationItemIterator = location.getLocationItemIterator();
                for(locationItemIterator.reset();locationItemIterator.hasNext();locationItemIterator.next()){
                    locationItemIterator.touchCurrent(this);
                    if(locationItemIterator.getCurrent().shouldBeRemoved()) locationItemIterator.removeCurrent();
                }
                notifyView(direction);
            }
        }
    }

    public void teleport(Location location){
        this.location = location;
        notifyView();
    }

    // getters
    public int getHealth(){
        return health;
    }

    public int getMaxHealth() { return maxHealth; }

    public int getExperience(){
        return experience;
    }

    public int getLevel(){
        return level;
    }

    public int getExperienceForNextLevel(){
        if(level < finalLevel)
            return ExperienceForLevel.get(level + 1);
        else return -1;
    }

    public int getExperienceForCurrentLevel(){
        return ExperienceForLevel.get(level);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
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

    public void notifyView(Direction direction){
        for (Viewport viewport : observers){
            viewport.moveUpdate(direction);
        }
        notifyView();
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