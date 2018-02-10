package View.AreaView;


import Configs.Commons;
import Configs.SpriteSizes;
import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DecalView extends Viewport {

    private Image decalImage;

    public DecalView(String fileName){
        ImageIcon imageIcon = new ImageIcon(fileName);
        decalImage = imageIcon.getImage();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(decalImage, parent.getLocationX()* SpriteSizes.TERRAIN_WIDTH, parent.getLocationY()*SpriteSizes.TERRAIN_HEIGHT,
                SpriteSizes.TERRAIN_WIDTH, SpriteSizes.TERRAIN_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
