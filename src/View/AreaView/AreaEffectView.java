package View.AreaView;


import Configs.SpriteSizes;
import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AreaEffectView extends Viewport {

    private Image areaEffectImage;

    public AreaEffectView(Image image){
        this.areaEffectImage = image;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(areaEffectImage, parent.getLocationX()*SpriteSizes.TERRAIN_WIDTH, parent.getLocationY()*SpriteSizes.TERRAIN_HEIGHT,
                SpriteSizes.AREA_EFFECT_WIDTH, SpriteSizes.AREA_EFFECT_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
