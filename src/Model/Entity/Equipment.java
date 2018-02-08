package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;
import com.sun.prism.image.ViewPort;

import java.util.List;

public class Equipment {

    private List<Viewport> observers;

    private TakeableItem equiped;

    public boolean equip(TakeableItem item){
        equiped = item;
        return true;
    }

    public boolean unEquip(TakeableItem item){
        if(equiped == item) {
            equiped = null;
            return true;
        }
        return false;
    }

    public TakeableItem getEquiped() {
        return equiped;
    }

    public void attach(Viewport viewport){
        observers.add(viewport);
    }

    public void detach(Viewport viewport){
        observers.remove(viewport);
    }

    public void notifyView(){
        for( Viewport viewport : observers) {
            viewport.update();
        }
    }
}
