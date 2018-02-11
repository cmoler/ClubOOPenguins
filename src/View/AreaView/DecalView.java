package View.AreaView;


import Configs.SpriteSizes;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DecalView extends Viewport {

    private Image decalImage;

    public DecalView(Image image){
        this.decalImage = image;
    }

    @Override
    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.drawImage(decalImage, x* SpriteSizes.TERRAIN_WIDTH + SpriteSizes.TERRAIN_WIDTH/4, y*SpriteSizes.TERRAIN_HEIGHT + SpriteSizes.TERRAIN_HEIGHT/4,
                SpriteSizes.DECAL_WIDTH, SpriteSizes.DECAL_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
