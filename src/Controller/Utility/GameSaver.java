package Controller.Utility;

import Model.Entity.Entity;
import Model.Map.World;
import Model.Map.Map;
import Model.Entity.Inventory;
import Model.Entity.Equipment;
import Model.Item.Item;
import java.io.PrintWriter;

public class GameSaver {

    private String saveFileLocation;

    public void SaveMap(String saveFileLocation, Entity entity, World world, Map map) {
        String mapData = "";

        //Placeholder until I can get actual MapID
        mapData += "0001" + System.getProperty("line.separator");

        mapData += "MAP" + System.getProperty("line.separator");
        mapData += "\t" + Integer.toString(map.getRows()) + System.getProperty("line.separator");
        mapData += "\t" + Integer.toString(map.getCols()) + System.getProperty("line.separator");

        //Needs to be replaced with a function to return actual starting point
        mapData += "\t" + Integer.toString(map.getRows() / 2) + "," + Integer.toString(map.getCols() / 2) + System.getProperty("line.separator");

        mapData += "\tLOCATIONS";

        for(int i = 0; i < map.getRows(); i++) {
            for(int j = 0; j < map.getCols(); j++) {
                mapData += "\t\t" + Integer.toString(j) + "," + Integer.toString(i) + System.getProperty("line.separator");
                mapData += "\t\t\t" + map.getLocationIJ(i, j).getTerrain().toString().toUpperCase();

                if(map.getLocationIJ(i, j).moveAllowed(entity)) mapData += "\t\t\tFALSE" + System.getProperty("line.separator");
                else mapData += "\t\t\tTRUE" + System.getProperty("line.separator");

                mapData += "\t\t\t" + map.getLocationIJ(i, j).getAreaEffect().toString().toUpperCase() + System.getProperty("line.separator");
                mapData += "\t\t\tITEMS" + System.getProperty("line.separator");

                //Converts Item list to strings
                String[] items = new String[map.getLocationIJ(i, j).getItems().size()];
                for(Object value : map.getLocationIJ(i, j).getItems()) {
                    mapData += "\t\t\t\t" + value.toString() + System.getProperty("line.separator");
                    if(value.toString().equals("TELEPORTER")) {
                        //Get teleporter info
                    }
                    else {
                        //Get item details
                    }
                }
            }
        }

        try(PrintWriter mapSave = new PrintWriter(saveFileLocation + "Map_Save.txt")) {
            mapSave.println(mapData);
            mapSave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }
    }

    public void SaveEntity(String saveFileLocation, Entity entity, World world, Map map, Inventory inventory, Equipment equipment) {
        String entityData = "";

        //Placeholder until I can get actual EntityID
        entityData += "0001" + System.getProperty("line.separator");

        entityData += "ENTITY" + System.getProperty("line.separator");

        entityData += "\t" + entity.getEntityType().toString().toUpperCase() + System.getProperty("line.separator");

        entityData += "\t" + entity.getLocation().toString();

        entityData += "\t" + Integer.toString(entity.getHealth()) + System.getProperty("line.separator");

        entityData += "\t" + Integer.toString(entity.getExperience()) + System.getProperty("line.separator");

        entityData += "\t" + "INVENTORY" + System.getProperty("line.separator");
        Inventory.InventoryIterator invIter = inventory.getIterator();
        invIter.reset();

        while(invIter.hasNext()) {
            entityData += "\t\t" + invIter.getCurrent().toString() + System.getProperty("line.separator");
            invIter.next();
        }

        entityData += "\t\t" + "EQUIPMENT" + System.getProperty("line.separator");
        entityData += "\t\t\t" + equipment.getEquipped().toString() + System.getProperty("line.separator");

        try(PrintWriter entitySave = new PrintWriter(saveFileLocation + "Entity_Save.txt")) {
            entitySave.println(entityData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }

    }

    public void SaveGame(String saveFileLocation, Entity entity, World world, Map map, Inventory inventory, Equipment equipment){

        SaveMap(saveFileLocation, entity, world, map);

        SaveEntity(saveFileLocation, entity, world, map, inventory, equipment);

    }
}
