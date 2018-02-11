package Model.Entity;

import Model.Item.Item;
import Model.Item.TakeableItem;
import View.Viewport;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Viewport> observers;

    private List<TakeableItem> items;
    private Equipment equipment;

    public InventoryIterator getIterator(){
        return new InventoryIterator();
    }

    public Inventory() {
        observers = new ArrayList<>();
        items = new ArrayList<>();
        equipment = new Equipment();
    }

    public boolean addItem(TakeableItem item){
        boolean itemAdded;
        itemAdded = items.add(item);
        if(itemAdded) { notifyView(); }

        return itemAdded;
    }

    public boolean removeItem(TakeableItem item){
        boolean itemRemoved;
        itemRemoved = items.remove(item);
        if(itemRemoved) { notifyView(); }

        return itemRemoved;
    }

    public TakeableItem removeItem(int index){
        TakeableItem removedItem;
        removedItem = items.remove(index);
        notifyView();

        return removedItem;
    }

    public boolean doesExist(TakeableItem item){
        boolean itemExists;
        itemExists = items.contains(item);

        return itemExists;
    }

    public boolean equip(TakeableItem item) {
        if(equipment.equip(item)) {
            removeItem(item);
            return true;
        }
        else { return false; }
    }

    public boolean unEquip(TakeableItem item) {
        if(equipment.unEquip(item)) {
            addItem(item);
            return true;
        }
        else { return false; }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public TakeableItem getEquipped() {
        return equipment.getEquipped();
    }

    public void attach(Viewport viewport){
        observers.add(viewport);
    }

    public void detach(Viewport viewport){
        observers.remove(viewport);
    }

    public void notifyView(){
        for (Viewport viewport : observers){
            viewport.update();
        }
    }

    public class InventoryIterator{
        int index;

        public void reset(){
            index = 0;
        }

        public boolean hasNext(){
            return items.size() > index;
        }

        public boolean hasPrev(){
            return index > 1;
        }

        public void prev(){
            index -= 1;
        }

        public void next(){
            index += 1;
        }

        public TakeableItem getCurrent(){
            return items.get(index);
        }
    }

}
