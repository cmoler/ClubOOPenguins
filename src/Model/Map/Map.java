package Model.Map;

import Model.Map.Terrain.Ice;
import View.Viewport;

public class Map {

    // TODO add map iterator

    private Location[][] locations;
    private Location defaultLocation;

    //Default Location is center of map
    public Map(int x, int y)
    {
        this.locations = new Location[x][y];
        this.defaultLocation = locations[x/2][y/2];

        // for testing: Locations need to be initialized to test Entity movement
        for (Location[] row : this.locations){
            for (Location l : row){
                l = new Location(new Ice(), false, null, null);
            }
        }
        for (Location[] row : this.locations){
            for (Location l : row){
                // make list of adjacent locations
                //l.setAdjacentLocations(...);
            }
        }
        // --------------------------------------- //
    }

    //Default Location is specified
    public Map(int x, int y, Location defaultLocation)
    {
        this.locations = new Location[x][y];
        this.defaultLocation = defaultLocation;
    }

    // used in MapBuilder
    public Map(Location[][] locations, Location defaultLocation){
        this.locations = locations;
        this.defaultLocation = defaultLocation;
    }

    public Location getDefaultLocation(){
        return defaultLocation;
    }

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
