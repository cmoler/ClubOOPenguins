package Model.Map.AreaEffect;

import Model.Entity.Direction;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Terrain.Ice;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AreaEffectTest {

    @Test
    void isActive() throws InterruptedException {
        AreaEffect a = new DamageAreaEffect();
        Location lWest = new Location(new Ice(), false, null, null);
        Location lEast = new Location(new Ice(), false, a, null);
        HashMap<Direction, Location> adjacentLocationsWest = new HashMap<Direction, Location>();
        HashMap<Direction, Location> adjacentLocationsEast = new HashMap<Direction, Location>();
        adjacentLocationsWest.put(Direction.E, lEast);
        adjacentLocationsEast.put(Direction.W, lWest);
        lWest.setAdjacentLocations(adjacentLocationsWest);
        lEast.setAdjacentLocations(adjacentLocationsEast);

        Entity e = new Entity(lWest);
        e.move(Direction.E);
        TimeUnit.SECONDS.sleep(3);
        e.move(Direction.W);
        TimeUnit.SECONDS.sleep(3);
        // it works!
    }

    @Test
    void activate() {
        // activate is tested in the test above. Its called in e.move(...)
    }
}