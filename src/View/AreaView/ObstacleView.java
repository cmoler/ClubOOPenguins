package View.AreaView;

import Configs.SpriteSizes;
import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ObstacleView extends Viewport {

    private Image obstacleImage;

    public ObstacleView(Image image){
        this.obstacleImage = image;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(obstacleImage, (parent.getLocationY()* SpriteSizes.TERRAIN_WIDTH), (parent.getLocationY()*SpriteSizes.TERRAIN_HEIGHT),
                SpriteSizes.OBSTACLE_WIDTH, SpriteSizes.OBSTACLE_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
