package Model.Entity;

import Model.Item.Item;
import Model.Item.TakeableItem;
import View.Viewport;

import java.util.List;

public class Inventory {

    private List<TakeableItem> items;
    private Equipment equipment;

    public InventoryIterator getIterator(){
        return new InventoryIterator();
    }

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

    public class InventoryIterator{
        int index;

        public void reset(){
            index = 0;
        }

        public boolean hasNext(){
            return items.size() > index;
        }

        public void next(){
            index += 1;
        }

        public Item getCurrent(){
            return items.get(index);
        }
    }

}
