package Model.Item;

import Model.Entity.Entity;

public class OneShotItem extends Item{
    @Override
    public void touch(Entity entity) {

    }

    public boolean shouldBeRemoved(){
        return true;
    }
}
