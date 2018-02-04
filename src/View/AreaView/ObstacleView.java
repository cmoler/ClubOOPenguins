package View.AreaView;

import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ObstacleView extends Viewport {

    private Image obstacleImage;

    public ObstacleView(String fileName, Location location){
        ImageIcon imageIcon = new ImageIcon(fileName);
        obstacleImage = imageIcon.getImage();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(obstacleImage, parent.getX(), parent.getY(),
                parent.getWidth(), parent.getHeight(),this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
