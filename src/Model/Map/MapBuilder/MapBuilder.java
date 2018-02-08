package Model.Map.MapBuilder;

import Configs.Commons;
import Model.Entity.Entity;
import Model.Entity.EntityType;
import Model.Item.*;
import Model.Map.AreaEffect.*;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Terrain.Glacier;
import Model.Map.Terrain.Ice;
import Model.Map.Terrain.Terrain;
import Model.Map.Terrain.Water;
import View.AreaView.AreaEffectView;
import View.AreaView.ItemView.ItemView;
import View.AreaView.LocationView;
import View.AreaView.ObstacleView;
import View.AreaView.TerrainView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Configs.Commons.AREAEFFECT_DAMAGE_IMAGE;

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
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);

        Location[][] locations = new Location[height][width];

        String[] defaultPositions = mapData.get(lineIndex++).split("\t")[1].split(",");
        int defaultX = Integer.parseInt(defaultPositions[0]);
        int defaultY = Integer.parseInt(defaultPositions[1]);
        System.out.println("Default x: " + defaultX);
        System.out.println("Default y: " + defaultY);
        lineIndex++; // line is "LOCATIONS"
        while(mapData.get(lineIndex).substring(0,2).equals("\t\t")){
            // Getting location
            String[] locationCoords = mapData.get(lineIndex++).split("\t\t")[1].split(",");
            int xCoord = Integer.parseInt(locationCoords[0]);
            int yChord = Integer.parseInt(locationCoords[1]);
            System.out.println(" x: " + xCoord);
            System.out.println(" y: " + yChord);

            /*
        NOT SURE WHERE THIS GOES WITH THE WHILE LOOP BUT I FEEL LIKE IT MIGHT BE INSIDE
         */

            //Getting Terrain
            Terrain terrain = null;
            TerrainView terrainView = null;
            String terrainType = mapData.get(lineIndex++).split("\t\t\t")[1];
            switch (terrainType){
                case "ICE":
                    terrain = new Ice();
                    terrainView = new TerrainView(Commons.ICE_IMAGE);
                    break;
                case "WATER":
                    terrain = new Water();
                    terrainView = new TerrainView(Commons.WATER_IMAGE);
                    break;
                case "GLACIER":
                    terrain = new Glacier();
                    terrainView = new TerrainView(Commons.GLACIER_IMAGE);
                    break;
            }
            System.out.println("    terrain: " + terrainType);

            // Getting Obstacle
            String obstacle = mapData.get(lineIndex++).split("\t\t\t")[1];
            boolean obstacleBool = false;
            ObstacleView obstacleView = null;
            if(obstacle.equals("TRUE")){
                obstacleBool = true;
                obstacleView = new ObstacleView(Commons.OBSTACLE_IMAGE);
            }
            System.out.println("    obstacle: " + obstacle);

            // Getting AreaEffect
            String areaEffectType = mapData.get(lineIndex++).split("\t\t\t")[1];
            AreaEffect areaEffect;
            AreaEffectView areaEffectView = null;
            switch (areaEffectType){
                case "DAMAGE":
                    areaEffect = new DamageAreaEffect();
                    areaEffectView = new AreaEffectView(Commons.AREAEFFECT_DAMAGE_IMAGE);
                    break;
                case "HEAL":
                    areaEffect = new HealAreaEffect();
                    areaEffectView = new AreaEffectView(Commons.AREAEFFECT_HEAL_IMAGE);
                    break;
                case "KILL":
                    areaEffect = new KillAreaEffect();
                    areaEffectView = new AreaEffectView(Commons.AREAEFFECT_KILL_IMAGE);
                    break;
                case "LEVELUP":
                    areaEffect = new LevelUpAreaEffect();
                    areaEffectView = new AreaEffectView(Commons.AREAEFFECT_LEVELUP_IMAGE);
                    break;
                default:
                    areaEffect = null;
            }
            System.out.println("    area effect: " + areaEffectType);

            // Get Items
            lineIndex++; // line is "ITEMS"
            List<Item> items = new ArrayList<Item>();
            List<ItemView> itemViews = new ArrayList<ItemView>();
            while (mapData.get(lineIndex).substring(0, 4).equals("\t\t\t\t")) {
                String itemType = mapData.get(lineIndex).split("\t\t\t\t")[1];
                System.out.println("    item: " + itemType);
                switch (itemType) {
                    case "INTERACTIVE":
                        items.add(new InteractiveItem());
                        itemViews.add(new ItemView(Commons.ITEM_ITERACTIVE_IMAGE));
                        break;
                    case "ONESHOT":
                        items.add(new OneShotItem());
                        itemViews.add(new ItemView(Commons.ITEM_ONESHOT_IMAGE));
                        break;
                    case "TAKEABLE":
                        items.add(new TakeableItem());
                        itemViews.add(new ItemView(Commons.ITEM_TAKEABLE_IMAGE));
                        break;
                    case "TELEPORTER":
                        lineIndex++;
                        String teleporterMapID = mapData.get(lineIndex++).split("\t\t\t\t\t")[1];
                        String[] teleporterLocationXAndY = mapData.get(lineIndex).split("\t\t\t\t\t")[1].split(",");
                        int teleportLocationX = Integer.parseInt(teleporterLocationXAndY[0]);
                        int teleportLocationY = Integer.parseInt(teleporterLocationXAndY[1]);
                        items.add(new Teleporter(teleporterMapID,teleportLocationX,teleportLocationY));
                        itemViews.add(new ItemView(Commons.ITEM_TELEPORTER_IMAGE));
                        System.out.println("        mapID: " + teleporterMapID);
                        System.out.println("        x: " + teleportLocationX);
                        System.out.println("        y: " + teleportLocationY);
                        break;
                }
                lineIndex++;
        }

            locations[yChord][xCoord] = new Location(terrain, obstacleBool, areaEffect, items);
            LocationView locationView = new LocationView(locations[yChord][xCoord], xCoord, yChord);
            if(terrainView != null) locationView.add(terrainView);
            if(obstacleView != null) locationView.add(obstacleView);
            if(areaEffectView != null) locationView.add(areaEffectView);
            for(ItemView itemView: itemViews){
                locationView.add(itemView);
            }

        }

        lineIndex++; // line is "ENTITIES"
        while(lineIndex < mapData.size()){
            String[] entityPositions = mapData.get(lineIndex++).split("\t")[1].split(",");
            int entityX = Integer.parseInt(entityPositions[0]);
            int entityY = Integer.parseInt(entityPositions[1]);
            String terrainType = mapData.get(lineIndex++).split("\t")[1];
            EntityType entityType;
            switch (terrainType){
                case "ICE":
                    entityType = EntityType.ICE;
                    break;
                case "WATER":
                    entityType = EntityType.WATER;
                    break;
                case "GLACIER":
                    entityType = EntityType.GLACIER;
                    break;
            }
            Entity e = new Entity(locations[entityX][entityY]);
        }

        return new Map(1,1); //
    }

}