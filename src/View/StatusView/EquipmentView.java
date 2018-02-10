package View.StatusView;

import Configs.Commons;
import Model.Entity.Equipment;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EquipmentView extends Viewport {

    private final int EQUIPMENT_X = (int) (Commons.SCREEN_WIDTH * 630.0/765.0);
    private final int EQUIPMENT_Y = (int) (Commons.SCREEN_HEIGHT * 225.0/501.0);

    private Equipment equipment;

    public EquipmentView(Equipment equipment){
        equipment.attach(this);
        this.equipment = equipment;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        //TODO get item equipment
        ImageIcon imageIcon = new ImageIcon("takeableItem.png");
        Image itemImage = imageIcon.getImage();

        graphics2D.drawImage(itemImage, EQUIPMENT_X, EQUIPMENT_Y, this);
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

}
