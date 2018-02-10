package View.StatusView;

import Configs.InventorySizes;
import Model.Entity.Inventory;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryView extends Viewport {

    private Inventory inventory;
    private Image highlighter;
    private int highlighterX = 0;
    private int highlighterY = 0;

    public InventoryView(Inventory inventory){
        inventory.attach(this);
        this.inventory = inventory;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Inventory.InventoryIterator inventoryIterator = inventory.getIterator();

        inventoryIterator.reset();
        for(int i = 0; i < InventorySizes.INVENTORY_ROWS && inventoryIterator.hasNext(); ++i, inventoryIterator.next()){
            for(int j = 0; j < InventorySizes.INVENTORY_COLUMNS && inventoryIterator.hasNext(); ++j, inventoryIterator.next()){
                ImageIcon imageIcon = new ImageIcon("takeableItem.png");
                Image itemImage = imageIcon.getImage();

                graphics2D.drawImage(itemImage, i, j, this);
            }
        }
        for(inventoryIterator.reset(); inventoryIterator.hasNext(); inventoryIterator.next()){

            i++;
        }
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
