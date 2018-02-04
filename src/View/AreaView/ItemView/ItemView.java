package View.AreaView.ItemView;


import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemView extends Viewport {

    private Image itemImage;

    public ItemView(String fileName, Location location){
        ImageIcon imageIcon = new ImageIcon("fileName");
        itemImage = imageIcon.getImage();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(itemImage, parent.getX(), parent.getY(),
                parent.getWidth(), parent.getHeight(),this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

}
