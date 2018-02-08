package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

    private List<Viewport> observers;

    private TakeableItem equipped;

    public Equipment() {
        observers = new ArrayList<>();
    }

    public boolean equip(TakeableItem item){
        equipped = item;
        return true;
    }

    public boolean unEquip(TakeableItem item){
        if(equipped == item) {
            equipped = null;
            return true;
        }
        return false;
    }

    public TakeableItem getEquipped() {
        return equipped;
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
