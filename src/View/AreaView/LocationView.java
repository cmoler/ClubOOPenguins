package View.AreaView;


import Model.Map.Location;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class LocationView extends Viewport {

    private Location location;
    private int x;
    private int y;

    public LocationView(Location location, int x, int y){
        this.location = location;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getLocationX(){
        return x;
    }

    @Override
    public int getLocationY(){
        return y;
    }

}
