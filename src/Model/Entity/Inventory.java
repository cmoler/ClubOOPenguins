package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;

import java.util.List;

public class Inventory {

    private List<TakeableItem> items;
    private Equipment equipment;

    public boolean addItem(TakeableItem item){
        return false;
    }

    public boolean removeItem(TakeableItem item){
        return false;
    }

    public TakeableItem removeItem(int index){
        return null;
    }

    public boolean doesExist(TakeableItem item){
        return false;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }

}
