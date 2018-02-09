package Model.Item;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Terrain.Ice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TakeableItemTest {

    @Test
    void touch() {
        TakeableItem i = new TakeableItem();
        Entity e = new Entity(new Location(new Ice(), false,null,null));
        i.touch(e);
        assertEquals(true, e.getInventory().doesExist(i), "TakeableItem was put in Inventory");
    }

    @Test
    void shouldBeRemoved() {
    }
}