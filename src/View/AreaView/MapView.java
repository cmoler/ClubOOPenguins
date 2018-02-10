package View.AreaView;

import Model.Entity.Entity;
import Model.Map.Map;
import Model.Map.MapIterator;
import Model.Map.World;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class MapView extends Viewport {

    private final int VIEW_SIZE_X = 20;
    private final int VIEW_SIZE_Y = 20;

    private Entity entity;

    public MapView() {

    }

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    @Override
    public void draw(Graphics2D graphics2D){
        int i = 0;
        int j = 0;
        MapIterator mapIterator = new MapIterator(World.getWorld().getCurrentMap());
        for(mapIterator.reset(); mapIterator.isValid(); mapIterator.next()){
            if(mapIterator.currentItem() == entity.getLocation()){
                i = mapIterator.getI();
                j = mapIterator.getJ();
            }
        }
        for(Viewport child: children){
            if(child.getLocationX() <= j + 2 && child.getLocationX() >= j - 2&&
                    child.getLocationY() <= i + 2 && child.getLocationY() >= i - 2 ){
                child.draw(graphics2D);
            }
        }
    }

}
