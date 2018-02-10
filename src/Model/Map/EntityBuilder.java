package Model.Map;

import Configs.Commons;
import Model.Entity.Entity;
import Model.Entity.EntityType;
import Model.Map.Terrain.Ice;
import Model.Map.Terrain.Water;
import View.AreaView.TerrainView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntityBuilder {

    public EntityBuilder(){}

    public Entity buildEntity(String entityID) throws FileNotFoundException {

        String filename = "tests/Model/Map/EntityBuilder/EntityModel" + entityID + ".txt";

        Scanner s = new Scanner(new File(filename));
        List<String> mapData = new ArrayList<String>();
        while (s.hasNextLine()) {
            mapData.add(s.nextLine());
        }

        Entity e;

        int lineIndex = 2;
        EntityType entityType;
        String entityTypeString = mapData.get(lineIndex++).split("\t")[1];
        switch (entityTypeString){
            case "ICE":
                entityType = EntityType.ICE;
//                terrainView = new TerrainView(Commons.ICE_IMAGE);
                break;
            case "WATER":
                entityType = EntityType.WATER;
//                terrainView = new TerrainView(Commons.WATER_IMAGE);
                break;
        }
        int width = Integer.parseInt(mapData.get(lineIndex++).split("\t")[1]);


        return new Entity();
    }
}
