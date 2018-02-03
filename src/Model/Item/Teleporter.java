package Model.Item;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;

public class Teleporter extends TakeableItem{

    private Map map;
    private Location location;

    @Override
    public void touch(Entity entity) {

    }
}
