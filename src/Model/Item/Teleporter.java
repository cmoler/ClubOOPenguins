package Model.Item;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.World;

public class Teleporter extends InteractiveItem{

//    TODO - how to update world map?

    private Map map;
    private Location location;

    public Teleporter(Map map, Location location){
        this.map = map;
        this.location = location;
    }

    @Override
    public void touch(Entity entity) {
        entity.teleport(location);
        World.getWorld().changeCurrentMapTo(map);
    }

    public boolean shouldBeRemoved(){
        return false;
    }
}
