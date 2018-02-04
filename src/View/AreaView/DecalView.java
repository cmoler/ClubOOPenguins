package View.AreaView;


import View.Viewport;

import java.awt.*;
import java.util.List;

public class DecalView extends Viewport {

    private Image decalImage;

    public DecalView(String fileName, Location location){
        ImageIcon imageIcon = new ImageIcon("fileName");
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
