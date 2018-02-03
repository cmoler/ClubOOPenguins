package Model.Map.Terrain;

import Model.Entity.EntityType;

public class Ice extends Terrain{
    @Override
    public boolean enter(EntityType entityType) {
        return false;
    }
}
