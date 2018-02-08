package Model.Map;

import Model.Map.Terrain.Ice;
import View.Viewport;
import Model.Map.Location;

import java.util.HashMap;

import static Model.Map.Direction.*;

public class Map {

    // TODO add map iterator

    private Location[][] locations;
    private Location defaultLocation;
    private int numRows = 0;
    private int numCols = 0;

    //Default Location is center of map
    public Map(Location[][] allLocations) {
        this.locations = allLocations;
        numRows = this.locations.length;
        numCols = this.locations[0].length;
        this.defaultLocation = locations[numRows / 2][numCols / 2];
        setAdjacencyList();
    }

    //Default Location is specified
    // used in MapBuilder
    public Map(Location[][] locations, Location defaultLocation) {
        this.locations = locations;
        numRows = this.locations.length;
        numCols = this.locations[0].length;
        this.defaultLocation = defaultLocation;
        setAdjacencyList();
    }

    //Create x by y map for testing
    public Map(int x, int y)
    {
        this.locations = new Location[x][y];
        numRows = this.locations.length;
        numCols = this.locations[0].length;
        this.defaultLocation = locations[x/2][y/2];

        // for testing: Locations need to be initialized to test Entity movement
        for (int i = 0; i < numRows - 1; i++) {
            for (int j = 0; j < numCols - 1; j++) {
                locations[i][j] = new Location(new Ice(), false, null, null);
            }
        }

        setAdjacencyList();
        // --------------------------------------- //
    }

    public void setAdjacencyList() {
        for (int i = 0; i < numRows - 1; i++) {
            for (int j = 0; j < numCols - 1; j++) {
                HashMap AdjacentLocations = new HashMap<Direction, Location>();

                //Add NW
                if (i - 1 >= 0 && j - 1 >= 0) {
                    AdjacentLocations.put(NW, locations[i - 1][j - 1]);
                }
                else {
                    AdjacentLocations.put(NW, null);
                }

                //Add N
                if (i - 1 >= 0) {
                    AdjacentLocations.put(N, locations[i - 1][j]);
                }
                else {
                    AdjacentLocations.put(N, null);
                }

                //Add NE
                if (i - 1 >= 0 && j + 1 < numCols) {
                    AdjacentLocations.put(NE, locations[i - 1][j + 1]);
                }
                else {
                    AdjacentLocations.put(NE, null);
                }

                //Add W
                if (j - 1 >= 0) {
                    AdjacentLocations.put(W, locations[i][j - 1]);
                }
                else {
                    AdjacentLocations.put(W, null);
                }

                //Add E
                if (j + 1 < numCols) {
                    AdjacentLocations.put(E, locations[i][j + 1]);
                }
                else {
                    AdjacentLocations.put(E, null);
                }

                //Add SW
                if (i + 1 < numRows && j - 1 >= 0) {
                    AdjacentLocations.put(SW, locations[i + 1][j - 1]);
                }
                else {
                    AdjacentLocations.put(SW, null);
                }

                //Add S
                if (i + 1 < numRows) {
                    AdjacentLocations.put(S, locations[i + 1][j]);
                }
                else {
                    AdjacentLocations.put(S, null);
                }

                //Add SE
                if (i + 1 < numRows && j + 1 < numCols) {
                    AdjacentLocations.put(SE, locations[i + 1][j + 1]);
                }
                else {
                    AdjacentLocations.put(SE, null);
                }

                locations[i][j].setAdjacentLocations(AdjacentLocations);
            }
        }


    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public void setLocation(int x, int y, Location location) {locations[x][y] = location;}

    public void attach(Viewport viewport) {

    }

    public void detach(Viewport viewport) {

    }

    public void notifyView() {

    }
}
