package Controller.Utility;

import Model.Entity.Entity;
import Model.Item.Teleporter;
import Model.Map.World;
import Model.Map.Map;
import Model.Entity.Inventory;
import Model.Entity.Equipment;
import Model.Item.Item;
import Model.Map.MapIterator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameSaver {

    private String saveFileLocation;

    public void OutFile(String saveData) {
        try(PrintWriter entitySave = new PrintWriter(new FileOutputStream(saveFileLocation + ".txt", false))) {
            entitySave.println(saveData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }
    }

    public void SaveMap(String mapID, Entity entity, Map map) {
        String mapData = "";

        System.out.println("Saving map");

        mapData += mapID + System.lineSeparator();
        mapData += "MAP" + System.lineSeparator();

        mapData += "\t" + Integer.toString(map.getCols()) + System.lineSeparator();
        mapData += "\t" + Integer.toString(map.getRows()) + System.lineSeparator();

        MapIterator mi = new MapIterator(World.getWorld().getMap(mapID));

        for(mi.reset(); mi.isValid(); mi.next()) {
            if(mi.currentItem() == World.getWorld().getMap(mapID).getDefaultLocation()) {
                mapData += "\t" + Integer.toString(mi.getJ()) + "," + Integer.toString(mi.getI()) + System.lineSeparator();
            }
        }

        mapData += "\tLOCATIONS" + System.lineSeparator();

        for(int i = 0; i < map.getRows(); i++) {
            for(int j = 0; j < map.getCols(); j++) {
                mapData += "\t\t" + Integer.toString(i) + "," + Integer.toString(j) + System.lineSeparator();
                mapData += "\t\t\t" + map.getLocationIJ(i, j).getTerrain().toString().toUpperCase() + System.lineSeparator();

                if(map.getLocationIJ(i, j).moveAllowed(entity)) mapData += "\t\t\tFALSE" + System.lineSeparator();
                else mapData += "\t\t\tTRUE" + System.lineSeparator();

                if(map.getLocationIJ(i, j).getAreaEffect() != null) {
                    mapData += "\t\t\t" + map.getLocationIJ(i, j).getAreaEffect().toString().toUpperCase() + System.lineSeparator();
                }
                else
                    mapData += "\t\t\tNONE" + System.lineSeparator();

                mapData += "\t\t\tITEMS" + System.lineSeparator();

                //Converts Item list to strings
                String[] items = new String[map.getLocationIJ(i, j).getItems().size()];
                for(Item value : map.getLocationIJ(i, j).getItems()) {
                    mapData += "\t\t\t\t" + value.getItemType().toString().toUpperCase() + System.lineSeparator();

                    if(value.getItemType().toString().toUpperCase().equals("TELEPORTER")) {
                        //Get teleporter info
                        mapData += "\t\t\t\t\t" + ((Teleporter)value).getMapID() + System.lineSeparator();
                        mapData += "\t\t\t\t\t" + Integer.toString(((Teleporter)value).getX()) + "," + Integer.toString(((Teleporter)value).getY()) + System.lineSeparator();
                    }
                    else {
                        //Get item details
                    }
                }
            }
        }

        try(PrintWriter entitySave = new PrintWriter(new FileOutputStream("./resources/saves/" + "MapModel" + mapID + ".txt", false))) {
            entitySave.println(mapData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }
    }


    public void SaveEntity(Entity entity, String entityID, Inventory inventory) {
        String entityData = "";

        System.out.println("Entity ID: " + entityID);

        entityData += entityID + System.lineSeparator();

        entityData += "ENTITY" + System.lineSeparator();

        entityData += "\t" + entity.getEntityType().toString().toUpperCase() + System.lineSeparator();

        MapIterator mi = new MapIterator(World.getWorld().getCurrentMap());

        for(mi.reset(); mi.isValid(); mi.next()) {
            if(mi.currentItem() == World.getWorld().getCurrentMap().getDefaultLocation())
                entityData += "\t" + Integer.toString(mi.getJ()) + "," + Integer.toString(mi.getI()) + System.lineSeparator();
        }


        entityData += "\t" + Integer.toString(entity.getHealth()) + System.lineSeparator();

        entityData += "\t" + Integer.toString(entity.getExperience()) + System.lineSeparator();

        entityData += "\t" + "INVENTORY" + System.lineSeparator();

        Inventory.InventoryIterator invIter = inventory.getIterator();

        for(invIter.reset(); invIter.hasNext(); invIter.next()) {
            System.out.println("Checking for inventory");
            entityData += "\t\t" + invIter.getCurrent().getItemType().toString() + System.lineSeparator();
        }

        if(inventory.getEquipment().getEquipped() != null) {
            entityData += "\t\t" + "EQUIPMENT" + System.lineSeparator();
            entityData += "\t\t\t" + inventory.getEquipment().getEquipped().toString() + System.lineSeparator();
        }
        else
//            entityData += "\t\t\tNONE" + System.lineSeparator();

//        OutFile(entityData);

        try(PrintWriter entitySave = new PrintWriter(new FileOutputStream("./resources/saves/" + "EntityModel" + entityID + ".txt", false))) {
            entitySave.println(entityData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }

    }

    public void SaveGame(Entity entity, Map map, Inventory inventory, Equipment equipment){
//        Date date = new Date() ;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
//
//        saveFileLocation = saveFileLocation += "/" + dateFormat.format(date);

        for(int i = 1; World.getWorld().getMap("000" + Integer.toString(i)) != null; i++)
            SaveMap("000" + Integer.toString(i), entity, map);

        SaveEntity(entity, "0001", inventory);

    }
}
