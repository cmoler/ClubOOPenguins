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

    private int initialI;
    private int initialJ;

    private Entity entity;

    public MapView() {

    }

    public void setEntity(Entity entity){
        this.entity = entity;
        MapIterator mapIterator = new MapIterator(World.getWorld().getCurrentMap());
        for(mapIterator.reset(); mapIterator.isValid(); mapIterator.next()){
            if(mapIterator.currentItem() == entity.getLocation()){
                initialI = mapIterator.getI();
                initialJ = mapIterator.getJ();
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics2D){
        int offsetI = 0;
        int offsetJ = 0;
        MapIterator mapIterator = new MapIterator(World.getWorld().getCurrentMap());
        for(mapIterator.reset(); mapIterator.isValid(); mapIterator.next()){
            if(mapIterator.currentItem() == entity.getLocation()){
                offsetI = mapIterator.getI() - initialI;
                offsetJ = mapIterator.getJ() - initialJ;
            }
        }
        for(Viewport child: children){
            if(child.getLocationX() <= offsetJ + 3 && child.getLocationX() >= offsetJ - 2&&
                    child.getLocationY() <= offsetJ + 10 && child.getLocationY() >= offsetJ - 2 ){
                child.draw(graphics2D, child.getLocationX() - offsetJ, child.getLocationY() - offsetI);
            }
        }
    }

}
