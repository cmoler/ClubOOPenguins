package View.AreaView;


import Model.Map.Location;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class LocationView extends Viewport {

    private Location location;

    public LocationView(Location location){
        this.location = location;
    }

    @Override
    public int getX(){
        return location.getX();
    }

    @Override
    public int getY(){
        return location.getY();
    }

    @Override
    public int getWidth(){
        return location.getWidth();
    }

    @Override
    public int getHeight(){
        return location.getHeight();
    }

}
