package Model.Map.MapBuilder;

import Configs.Commons;
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
import View.Viewport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Configs.Commons.AREAEFFECT_DAMAGE_IMAGE;

public class MapBuilder {

    public MapBuilder(){}

    private Viewport viewport;

    public Viewport getViewport() {
        return viewport;
    }

    public Map buildMap(String mapID) throws FileNotFoundException {
        //String filename = "tests/Model/Map/MapBuilder/MapModel" + mapID + ".txt"; // will change after testing
        String filename = "resources/maps/MapModel"+mapID+".txt";
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

        Location[][] locations = new Location[height][width];

        String[] defaultPositions = mapData.get(lineIndex++).split("\t")[1].split(",");
        int defaultX = Integer.parseInt(defaultPositions[0]);
        int defaultY = Integer.parseInt(defaultPositions[1]);
        lineIndex++; // line is "LOCATIONS"
        while(mapData.get(lineIndex).substring(0,1).equals("\t\t")){
            // Getting location
            String[] locationCoords = mapData.get(lineIndex++).split("\t\t")[1].split(",");
            int xCoord = Integer.parseInt(locationCoords[0]);
            int yChord = Integer.parseInt(locationCoords[1]);

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

            // Getting Obstacle
            String obstacle = mapData.get(lineIndex++).split("\t\t\t")[1];
            boolean obstacleBool = false;
            ObstacleView obstacleView = null;
            if(obstacle.equals("TRUE")){
                obstacleBool = true;
                obstacleView = new ObstacleView(Commons.OBSTACLE_IMAGE);
            }

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

            // Get Items
            lineIndex++; // line is "ITEMS"
            List<Item> items = new ArrayList<Item>();
            List<ItemView> itemViews = new ArrayList<ItemView>();
            if(mapData.get(lineIndex).contains("\t\t\t")) {
                while (mapData.get(lineIndex).substring(0, 1).equals("\t\t")) {
                    String itemType = mapData.get(lineIndex++).split("\t")[1];
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
                            String teleporterMapID = mapData.get(lineIndex++).split("\t")[1];
                            String[] teleporterLocationXAndY = mapData.get(lineIndex++).split("\t")[1].split(",");
                            //                        items.add(new Teleporter());
                            itemViews.add(new ItemView(Commons.ITEM_TELEPORTER_IMAGE));
                            break;
                        default:
                            areaEffect = null;
                    }
                }
            }

            locations[yChord][xCoord] = new Location(terrain, obstacleBool, areaEffect, items);
            LocationView locationView = new LocationView(locations[yChord][xCoord], xCoord, yChord);
            if(terrainView != null) locationView.add(terrainView);
            if(areaEffectView != null) locationView.add(areaEffectView);
            if(obstacleView != null) locationView.add(obstacleView);
            for(ItemView itemView: itemViews){
                locationView.add(itemView);
            }

            this.viewport = locationView;


        }



            return new Map(1,1); //
    }

}