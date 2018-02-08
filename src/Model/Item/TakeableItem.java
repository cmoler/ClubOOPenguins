package Model.Item;

import Model.Entity.Entity;

public class TakeableItem extends Item{

    @Override
    public void touch(Entity entity) {

    }

    public boolean shouldBeRemoved(){
        return true; // always true?
    }
}
