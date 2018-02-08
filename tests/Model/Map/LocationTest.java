package Model.Map;

import Model.Entity.Entity;
import Model.Map.Terrain.Glacier;
import Model.Map.Terrain.Ice;
import Model.Map.Terrain.Water;
import org.junit.jupiter.api.Test;
import static Model.Entity.EntityType.ICE;
import static Model.Entity.EntityType.WATER;
import static org.junit.jupiter.api.Assertions.*;

class LocationTerrainTest {

//Location(Terrain terrain, boolean obstacle, AreaEffect areaEffect, List<Item> items
    @Test
   public void GlacierTest() {
        //Location is tested under GLACIER
        Location testGlacier = new Location(new Glacier(), false, null, null);
        Location testGlacierObstacle = new Location(new Glacier(), true, null, null);

        Entity iceEntity = new Entity(ICE, null);
        Entity waterEntity = new Entity(WATER, null);
        //assert statements
        assertEquals(false, testGlacier.moveAllowed(iceEntity), "ICE Entity CANNOT Pass GLACIER with no OBSTACLE");
        assertEquals(false, testGlacier.moveAllowed(waterEntity), "WATER Entity CANNOT Pass GLACIER with no OBSTACLE");
        assertEquals(false, testGlacierObstacle.moveAllowed(iceEntity), "ICE Entity CANNOT Pass GLACIER with OBSTACLE");
        assertEquals(false, testGlacierObstacle.moveAllowed(waterEntity), "WATER Entity CANNOT Pass GLACIER with OBSTACLE");
    }

    @Test
    public void WaterTest() {
        //Location is tested under WATER
        Location testWater = new Location(new Water(), false, null, null);
        Location testWaterObstacle = new Location(new Water(), true, null, null);

        Entity iceEntity = new Entity(ICE, null);
        Entity waterEntity = new Entity(WATER, null);
        //assert statements
        assertEquals(false, testWater.moveAllowed(iceEntity), "ICE Entity CANNOT Pass WATER with no OBSTACLE");
        assertEquals(true, testWater.moveAllowed(waterEntity), "WATER Entity CAN Pass WATER with no OBSTACLE");
        assertEquals(false, testWaterObstacle.moveAllowed(iceEntity), "ICE Entity CANNOT Pass WATER with OBSTACLE");
        assertEquals(false, testWaterObstacle.moveAllowed(waterEntity), "WATER Entity CANNOT Pass WATER with OBSTACLE");
    }

    @Test
    public void IceTest() {
        //Location is tested under ICE
        Location testIce = new Location(new Ice(), false, null, null);
        Location testIceObstacle = new Location(new Ice(), true, null, null);

        Entity iceEntity = new Entity(ICE, null);
        Entity waterEntity = new Entity(WATER, null);
        //assert statements
        assertEquals(true, testIce.moveAllowed(iceEntity), "ICE Entity CAN Pass ICE with no OBSTACLE");
        assertEquals(true, testIce.moveAllowed(waterEntity), "WATER Entity CAN Pass ICE with no OBSTACLE");
        assertEquals(false, testIceObstacle.moveAllowed(iceEntity), "ICE Entity CANNOT Pass ICE with OBSTACLE");
        assertEquals(false, testIceObstacle.moveAllowed(waterEntity), "WATER Entity CANNOT Pass ICE with OBSTACLE");
    }

}