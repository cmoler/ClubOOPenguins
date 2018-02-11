package Model.Entity;

import Model.Item.InteractiveItem;
import Model.Item.TakeableItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void addItem() {
        Entity e = new Entity();
        Inventory i = new Inventory(e);
        TakeableItem takeable1 = new TakeableItem();
        assertEquals(true, i.addItem(takeable1));
    }

    @Test
    void removeItem() {
        Entity e = new Entity();
        Inventory i = new Inventory(e);
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        i.addItem(item1);
        assertEquals(true, i.removeItem(item1));
        assertEquals(false, i.removeItem(item2));
    }

    @Test
    void doesExist() {
        Entity e = new Entity();
        TakeableItem item1 = new TakeableItem();
        TakeableItem item2 = new TakeableItem();
        TakeableItem item3 = new TakeableItem();
        Inventory i = new Inventory(e);
        i.addItem(item1);
        i.addItem(item2);
        assertEquals(true, i.doesExist(item1));
        assertEquals(true, i.doesExist(item2));
        assertEquals(false, i.doesExist(item3));
    }

    @Test
    void equip() {
        Entity e = new Entity();
        TakeableItem item1 = new TakeableItem();
        Inventory i = new Inventory(e);
        assertEquals(true, i.equip(item1));
        assertEquals(item1, i.getEquipped());
    }

    @Test
    void unEquip() {
        Entity e = new Entity();
        TakeableItem item1 = new TakeableItem();
        Inventory i = new Inventory(e);
        i.equip(item1);
        assertEquals(true, i.unEquip(item1));
        assertEquals(false, i.unEquip(item1));
    }

}