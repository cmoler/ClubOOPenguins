package View.StatusView;

import Model.Entity.Equipment;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EquipmentView extends Viewport {

    private final int EQUIPMENT_X = 20;
    private final int EQUIPMENT_Y = 20;

    private Equipment equipment;

    public EquipmentView(Equipment equipment){
        equipment.attach(this);
        this.equipment = equipment;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        ImageIcon imageIcon = new ImageIcon("takeableItem.png");
        Image itemImage = imageIcon.getImage();

        graphics2D.drawImage(itemImage, EQUIPMENT_X, EQUIPMENT_Y, this);
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

    @Override
    public void update(){

    }

}
