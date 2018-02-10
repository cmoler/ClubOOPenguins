package View.StatusView;


import Model.Entity.Entity;
import Model.Entity.Equipment;
import Model.Entity.Inventory;
import View.Viewport;

import java.awt.*;


public class StatusViewPort extends Viewport {

    public enum RenderOption { EQUIPMENT, INVENTORY}

    private RenderOption renderOption;

    public StatusViewPort(Entity entity, Equipment equipment, Inventory inventory){
        add(new StatsView(entity));
        add(new EquipmentView(equipment));
        add(new InventoryView(inventory));
    }

    @Override
    public void setRenderOption(RenderOption renderOption) {
        this.renderOption = renderOption;
    }

    @Override
    public void draw(Graphics2D graphics2D){

        children.get(0).draw(graphics2D);

        switch (renderOption){

            case EQUIPMENT:
                children.get(1).draw(graphics2D);

            case INVENTORY:
                children.get(2).draw(graphics2D);
        }
    }

}
