package Model.Item;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.World;

public class Teleporter extends InteractiveItem{

    private String mapID;
    private int locationX;
    private int locationY;

    public Teleporter(String mapID, int locationX, int locationY){
        this.mapID = mapID;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    @Override
    public void touch(Entity entity) {
        Map nextMap = World.getWorld().getMap(mapID);
        Location nextLocation = nextMap.getLocation(locationX,locationY);
        World.getWorld().changeCurrentMapTo(nextMap);
        entity.teleport(nextLocation);
    }

    public boolean shouldBeRemoved(){
        return false;
    }
}
