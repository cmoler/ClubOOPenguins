package Model.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    @Test
    void changeCurrentMapTo() {
        Map one = new Map(5, 5);
        Map two = new Map(10, 10);
        World.getWorld().changeCurrentMapTo(one);
        assertEquals(World.getWorld().getCurrentMap(), one,"Current map should be one");
        World.getWorld().changeCurrentMapTo(two);
        assertEquals(World.getWorld().getCurrentMap(), two, "Current map should now be two");
    }

}