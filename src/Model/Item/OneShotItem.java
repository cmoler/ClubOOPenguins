package Model.Item;

import Model.Entity.Entity;

public class OneShotItem extends Item{

    @Override
    public void touch(Entity entity) {
        entity.heal(10);
    }

    public boolean shouldBeRemoved(){
        return true;
    }

    public ItemType getItemType() {
        return ItemType.ONESHOT;
    }

}
