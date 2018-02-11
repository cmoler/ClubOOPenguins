package View.StatusView;


import Model.Entity.Entity;
import Model.Entity.Equipment;
import Model.Entity.Inventory;
import View.Viewport;

import java.awt.*;


public class StatusViewPort extends Viewport {


    public StatusViewPort(Entity entity, Equipment equipment, Inventory inventory){
        add(new StatsView(entity));
        add(new EquipmentView(equipment));
        add(new InventoryView(inventory));
    }


}
