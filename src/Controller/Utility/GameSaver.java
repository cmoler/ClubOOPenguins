package Controller.Utility;

import Model.Entity.Entity;
import Model.Entity.EntityType;
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

    public void SaveMap(String mapID, Entity entity) {
        String mapData = "";

        System.out.println("Saving map");

        mapData += mapID + System.lineSeparator();
        mapData += "MAP" + System.lineSeparator();

        mapData += "\t" + Integer.toString(World.getWorld().getMap(mapID).getCols()) + System.lineSeparator();
        mapData += "\t" + Integer.toString(World.getWorld().getMap(mapID).getRows()) + System.lineSeparator();

        MapIterator mi = new MapIterator(World.getWorld().getMap(mapID));

        for(mi.reset(); mi.isValid(); mi.next()) {
            if(mi.currentItem() == World.getWorld().getMap(mapID).getDefaultLocation()) {
                mapData += "\t" + Integer.toString(mi.getJ()) + "," + Integer.toString(mi.getI()) + System.lineSeparator();
            }
        }

        mapData += "\tLOCATIONS" + System.lineSeparator();

        for(int i = 0; i < World.getWorld().getMap(mapID).getRows(); i++) {
            for(int j = 0; j < World.getWorld().getMap(mapID).getCols(); j++) {
                mapData += "\t\t" + Integer.toString(i) + "," + Integer.toString(j) + System.lineSeparator();
                if(!World.getWorld().getMap(mapID).getLocationIJ(i,j).getTerrain().enter(EntityType.ICE) && !World.getWorld().getMap(mapID).getLocationIJ(i,j).getTerrain().enter(EntityType.WATER))
                    mapData += "\t\t\tGLACIER" + System.lineSeparator();
                else if(World.getWorld().getMap(mapID).getLocationIJ(i,j).getTerrain().enter(EntityType.WATER))
                    mapData += "\t\t\tICE" + System.lineSeparator();
                else if(World.getWorld().getMap(mapID).getLocationIJ(i,j).getTerrain().enter(EntityType.ICE))
                    mapData += "\t\t\tWATER" + System.lineSeparator();


                if(!World.getWorld().getMap(mapID).getLocationIJ(i, j).hasObstacle()) mapData += "\t\t\tFALSE" + System.lineSeparator();
                else mapData += "\t\t\tTRUE" + System.lineSeparator();

                if(World.getWorld().getMap(mapID).getLocationIJ(i, j).getAreaEffect() != null) {
                    mapData += "\t\t\t" + World.getWorld().getMap(mapID).getLocationIJ(i, j).getAreaEffect().getAreaEffectType().toString().toUpperCase() + System.lineSeparator();
                }
                else
                    mapData += "\t\t\tNONE" + System.lineSeparator();

                mapData += "\t\t\tITEMS" + System.lineSeparator();

                for(int k = 0; k < World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().size(); k++) {
                    mapData += "\t\t\t\t" + World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k).getItemType().toString().toUpperCase() + System.lineSeparator();

                    System.out.println("Adding to items: " + World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k).getItemType().toString().toUpperCase());

                    if(World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k).getItemType().toString().toUpperCase().equals("TELEPORTER")) {
                        //Get teleporter info
                        mapData += "\t\t\t\t\t" + ((Teleporter)World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k)).getMapID() + System.lineSeparator();
                        mapData += "\t\t\t\t\t" + Integer.toString(((Teleporter)World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k)).getX()) + "," + Integer.toString(((Teleporter)World.getWorld().getMap(mapID).getLocationIJ(i, j).getItems().get(k)).getY()) + System.lineSeparator();
                    }
                    else {
                        //Get item details
                    }
                }
            }
        }

        mapData = mapData.trim();

        try(PrintWriter entitySave = new PrintWriter(new FileOutputStream("./resources/maps_save/" + "MapModel" + mapID + ".txt", false))) {
            entitySave.println(mapData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }
    }


    public void SaveEntity(Entity entity, String entityID) {
        String entityData = "";

        System.out.println("Entity ID: " + entityID);

        entityData += entityID + System.lineSeparator();

        entityData += "ENTITY" + System.lineSeparator();

        entityData += "\t" + entity.getEntityType().toString().toUpperCase() + System.lineSeparator();

        MapIterator mi = new MapIterator(World.getWorld().getCurrentMap());

        for(mi.reset(); mi.isValid(); mi.next()) {
            if(mi.currentItem() == World.getWorld().getCurrentMap().getDefaultLocation()) {
                entityData += "\t" + Integer.toString(mi.getJ()) + "," + Integer.toString(mi.getI()) + System.lineSeparator();
                break;
            }
        }


        entityData += "\t" + Integer.toString(entity.getHealth()) + System.lineSeparator();

        entityData += "\t" + Integer.toString(entity.getExperience()) + System.lineSeparator();

        entityData += "\t" + "INVENTORY";

        Inventory.InventoryIterator invIter = entity.getInventory().getIterator();

        for(invIter.reset(); invIter.hasNext(); invIter.next()) {
            System.out.println("Checking for inventory");
            entityData += System.lineSeparator() + "\t\t" + invIter.getCurrent().getItemType().toString();
        }

        if(entity.getInventory().getEquipment().getEquipped() != null) {
            entityData += System.lineSeparator() + "\t\t" + "EQUIPMENT";
            entityData += System.lineSeparator() + "\t\t\t" + entity.getInventory().getEquipment().getEquipped().getItemType().toString();
        }

        try(PrintWriter entitySave = new PrintWriter(new FileOutputStream("./resources/entities_save/" + "EntityModel" + entityID + ".txt", false))) {
            entitySave.print(entityData);
            entitySave.close();
        }
        catch (Exception e) {
            System.out.println("Exception when writing to file");
        }

    }

    public void SaveGame(Entity entity){
//        Date date = new Date() ;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
//
//        saveFileLocation = saveFileLocation += "/" + dateFormat.format(date);

        for(int i = 1; World.getWorld().getMap("000" + Integer.toString(i)) != null; i++)
            SaveMap("000" + Integer.toString(i), entity);

        SaveEntity(entity, "0001");

    }
}
