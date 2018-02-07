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

        if(!mapData.get(0).equals(mapID))
            error("mapID error in " + filename);
        if(!mapData.get(1).equals("MAP"))
            error("format error--no MAP on second line");
        System.out.println(mapData.get(2).charAt(0));
        System.out.println(mapData.get(2).charAt(1));

        return new Map();
    }

    private void error(String message){
        System.out.println("MapBuilder.java: " + message);
    }

}