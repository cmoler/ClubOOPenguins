package Model.Entity;

import Model.Item.Item;
import Model.Item.Teleporter;
import Model.Map.Map;
import Model.Map.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void isAlive() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        assertEquals(true, e.isAlive(), "e should not be alive since it took 70 damage");
        e.takeDamage(40);
        assertEquals(false, e.isAlive(), "e should not be alive since it took 110 damage");
    }

    @Test
    void takeDamage() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        assertEquals(30, e.getHealth(), "e's health should be 30 since it took 70 damage");
    }

    @Test
    void heal() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m);
        Entity e = new Entity(m.getDefaultLocation());
        e.takeDamage(70);
        e.heal(20);
        assertEquals(50, e.getHealth(), "e's health should be 50 since it took 70 damage and 20 health");
    }

    @Test
    void gainExperience() {
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m);
        Entity e = new Entity(m.getDefaultLocation());
        e.gainExperience(50);
        assertEquals(50, e.getExperience(), "e's health should be 50 since it gained 50 xp");
        assertEquals(1, e.getLevel(), "e's level should be 1 since it's experience is 50");
        e.gainExperience(70);
        assertEquals(120, e.getExperience(), "e's health should be 120 since it gained 70 more xp");
        assertEquals(2, e.getLevel(), "e's level should be 2 since it's experience is 120");
    }

    @Test
    void teleport() {
//        Map m = new Map(5,5);
//        World.getWorld().changeCurrentMapTo(m);
//        Entity e = new Entity(m.getDefaultLocation());
//        Map mapToTeleportTo = new Map(6, 6);
//        Item i = new Teleporter(mapToTeleportTo, mapToTeleportTo.getDefaultLocation());
//        i.touch(e);
//        assertEquals(mapToTeleportTo.getDefaultLocation(), e.getLocation(), "e's location should be the teleported to's map's default location");
    }

    @Test
    void move(){}

    @Test
    void moveNormallyWithNoObstacles(){
        Map m = new Map(5,5);
        World.getWorld().changeCurrentMapTo(m);
        Entity e = new Entity(m.getDefaultLocation());
        e.move(Direction.E);
        assertEquals(m.getLocation(2,3),e.getLocation(),"e should have moved one location to the east");
    }
}