package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;

public class Equipment {

    private TakeableItem equiped;

    public boolean equip(TakeableItem item){
        return false;
    }

    public boolean unEquip(TakeableItem item){
        return false;
    }

    public TakeableItem getEquiped() {
        return equiped;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
