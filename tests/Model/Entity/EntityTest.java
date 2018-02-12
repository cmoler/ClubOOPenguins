package Model.Entity;


import Model.Map.Direction;
import Model.Map.Map;
import Controller.Utility.MapBuilder;
import Model.Map.World;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static Model.Map.Direction.E;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void isAlive() throws FileNotFoundException {
        MapBuilder mb = new MapBuilder();
        Map m = mb.buildMap("0001");
        World.getWorld().changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        assertEquals(true, e.isAlive(), "e should be alive since it took 70 damage");
        e.takeDamage(40);
        assertEquals(false, e.isAlive(), "e should not be alive since it took 110 damage");
    }

    @Test
    void takeDamage() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        assertEquals(30, e.getHealth(), "e's health should be 30 since it took 70 damage");
    }

    @Test
    void heal() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        e.heal(20);
        assertEquals(50, e.getHealth(), "e's health should be 50 since it took 70 damage and 20 health");
    }

    @Test
    void gainExperience() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.gainExperience(50);
        assertEquals(50, e.getExperience(), "e's health should be 50 since it gained 50 xp");
        assertEquals(1, e.getLevel(), "e's level should be 1 since it's experience is 50");
        e.gainExperience(70);
        assertEquals(120, e.getExperience(), "e's health should be 120 since it gained 70 more xp");
        assertEquals(2, e.getLevel(), "e's level should be 2 since it's experience is 120");
    }

    @Test
    void teleport() throws FileNotFoundException {
//        World world = World.getWorld();
//        MapBuilder mb = new MapBuilder();
//        Map m1 = mb.buildMap("0001");
//        Map m2 = mb.buildMap("0002");
//        world.addMap("0001", m1);
//        world.addMap("0002", m2);
//        world.changeCurrentMapTo(m1);
//        Entity e = new Entity(m1.getDefaultLocation());
//        e.move(Direction.W);
//        assertEquals(world.getMap("0002"), world.currentMap, "Current map should have changed to 0002");
//        // it works
    }

    @Test
    void move() throws FileNotFoundException {
        World world = World.getWorld();
        MapBuilder mb = new MapBuilder();
        Map m = mb.buildMap("0001");
        world.changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.move(Direction.N);
    }

    @Test
    void moveNormallyWithNoObstacles(){
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m, false);
        Entity e = new Entity(m.getDefaultLocation());
        e.move(E);
        assertEquals(m.getLocationIJ(2,3),e.getLocation(),"e should have moved one location to the east");
    }
}