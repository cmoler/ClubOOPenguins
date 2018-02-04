package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;

import java.util.List;

public class Inventory {

//    TODO - implement observer pattern

    private List<TakeableItem> items;
    private Equipment equipment;

    public boolean addItem(TakeableItem item){
        boolean itemAdded = false;
        itemAdded = items.add(item);

        return itemAdded;
    }

    public boolean removeItem(TakeableItem item){
        boolean itemRemoved = false;
        itemRemoved = items.remove(item);

        return itemRemoved;
    }

    public TakeableItem removeItem(int index){
        TakeableItem removedItem = null;
        removedItem = items.remove(index);

        return removedItem;
    }

    public boolean doesExist(TakeableItem item){
        boolean itemExists = false;
        itemExists = items.contains(item);

        return itemExists;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }

}
