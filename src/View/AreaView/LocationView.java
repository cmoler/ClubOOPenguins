package View.AreaView;


import Model.Map.Location;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class LocationView extends Viewport {

    private Location location;
    private int locationX;
    private int locationY;

    public LocationView(Location location, int x, int y){
        this.location = location;
        this.locationX = x;
        this.locationY = y;
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int j){
        for(Viewport child: children){
            child.draw(graphics2D, i, j);
        }
    }

    @Override
    public int getLocationX(){
        return locationX;
    }

    @Override
    public int getLocationY(){
        return locationY;
    }

    public Location getTerrainLocation() {
        return location;
    }
}
