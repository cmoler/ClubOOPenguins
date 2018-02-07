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
        String filename = "MapModel" + mapID + ".txt";
        Scanner s = new Scanner(new File(filename));
        List<String> mapData = new ArrayList<String>();
        while (s.hasNextLine()) {
            mapData.add(s.nextLine());
        }
        for(String line : mapData){
            System.out.println(line);
        }

        return new Map();
    }

}
