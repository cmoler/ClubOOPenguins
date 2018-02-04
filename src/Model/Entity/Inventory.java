package Model.Entity;

import Model.Item.TakeableItem;
import View.Viewport;

import java.util.List;

public class Inventory {

//    TODO - improve generic exception handling
//    TODO - implement observer pattern

    private List<TakeableItem> items;
    private Equipment equipment;

    public boolean addItem(TakeableItem item){
        boolean itemAdded = false;
        try {
            itemAdded = items.add(item);
        }
        catch (Exception e) {
            System.out.print(e);
        }
        return itemAdded;
    }

    public boolean removeItem(TakeableItem item){
        boolean itemRemoved = false;
        try {
            itemRemoved = items.remove(item);
        }
        catch (Exception e) {
            System.out.print(e);
        }
        return itemRemoved;
    }

    public TakeableItem removeItem(int index){
        TakeableItem removedItem = null;
        try {
            removedItem = items.remove(index);
        }
        catch (Exception e) {
            System.out.print(e);
        }
        return removedItem;
    }

    public boolean doesExist(TakeableItem item){
        boolean itemExists = false;
        try{
            itemExists = items.contains(item);
        }
        catch (Exception e) {
            System.out.print(e);
        }
        return itemExists;
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }

}
