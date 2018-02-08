package View.AreaView;


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
        graphics2D.drawImage(areaEffectImage, parent.getX(), parent.getY(),
                parent.getWidth(), parent.getHeight(),this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
