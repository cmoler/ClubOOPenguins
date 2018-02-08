package Model.Map.MapBuilder;
import Model.Map.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapBuilder {

    public MapBuilder(){}

    public Map buildMap(String mapID) throws FileNotFoundException {
        String filename = "tests/Model/Map/MapBuilder/MapModel" + mapID + ".txt"; // will change after testing

        Scanner s = new Scanner(new File(filename));
        List<String> mapData = new ArrayList<String>();
        while (s.hasNextLine()) {
            mapData.add(s.nextLine());
        }

        Map map;

        // first 2 lines are mapID and "MAP"
        int lineIndex = 2;
        int height = Integer.parseInt(mapData.get(lineIndex++).split("\t")[1]);
        int width = Integer.parseInt(mapData.get(lineIndex++).split("\t")[1]);
        String[] defaultPositions = mapData.get(lineIndex++).split("\t")[1].split(",");
        int defaultX = Integer.parseInt(defaultPositions[0]);
        int defaultY = Integer.parseInt(defaultPositions[1]);
        lineIndex++; // line is "LOCATIONS"
        while(mapData.get(lineIndex).substring(0,1).equals("\t\t")){
            String[] locationCoords = mapData.get(lineIndex++).split("\t")[1].split(",");
            int xCoord = Integer.parseInt(locationCoords[0]);
            int yChord = Integer.parseInt(locationCoords[1]);
        }

        return new Map();
    }

}