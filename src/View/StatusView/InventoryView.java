package View.StatusView;

import Model.Entity.Inventory;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryView extends Viewport {

    private Inventory inventory;

    public InventoryView(Inventory inventory){
        inventory.attach(this);
        this.inventory = inventory;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Inventory.InventoryIterator inventoryIterator = inventory.getIterator();

        int i = 0;
        for(inventoryIterator.reset(); inventoryIterator.hasNext(); inventoryIterator.next()){
            ImageIcon imageIcon = new ImageIcon("takeableItem.png");
            Image itemImage = imageIcon.getImage();

            graphics2D.drawImage(itemImage, i, i, this);
            i++;
        }
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
