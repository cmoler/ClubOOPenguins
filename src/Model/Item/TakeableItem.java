package Model.Item;

import Model.Entity.Entity;

public class TakeableItem extends Item{

//    TODO - remove item from location

    @Override
    public void touch(Entity entity) {
        entity.getInventory().addItem(this);
    }
}
