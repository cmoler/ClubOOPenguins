package Model.Map;

import View.Viewport;

public class Map {

    private Location[][] locations;

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public void attach(Viewport viewport){

    }

    public void detach(Viewport viewport){

    }

    public void notifyView(){

    }
}
