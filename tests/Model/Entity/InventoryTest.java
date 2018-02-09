package Model.Entity;

import Model.Item.InteractiveItem;
import Model.Item.TakeableItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void addItem() {
        Inventory i = new Inventory();
        TakeableItem takeable1 = new TakeableItem();
        assertEquals(true, i.addItem(takeable1));
    }

    @Test
    void removeItem() {
        Inventory i = new Inventory();
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        i.addItem(item1);
        assertEquals(true, i.removeItem(item1));
        assertEquals(false, i.removeItem(item2));
    }

    @Test
    void doesExist() {
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        TakeableItem item3 = new TakeableItem();
        Inventory i = new Inventory();
        i.addItem(item1);
        i.addItem(item2);
        assertEquals(true, i.doesExist(item1));
        assertEquals(true, i.doesExist(item2));
        assertEquals(false, i.doesExist(item3));
    }

    @Test
    void equip() {
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        Inventory i = new Inventory();
        assertEquals(true, i.equip(item1));
        assertEquals(item1, i.getEquipped());
    }

    @Test
    void unEquip() {
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        Inventory i = new Inventory();
        i.equip(item1);
        assertEquals(false, i.unEquip(item2));
        assertEquals(true, i.unEquip(item1));
    }

}