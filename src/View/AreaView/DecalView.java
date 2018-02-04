package View.AreaView;


import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DecalView extends Viewport {

    private Image decalImage;

    public DecalView(String fileName, Location location){
        ImageIcon imageIcon = new ImageIcon(fileName);
        decalImage = imageIcon.getImage();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(decalImage, parent.getX(), parent.getY(),
                parent.getWidth(), parent.getHeight(),this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
