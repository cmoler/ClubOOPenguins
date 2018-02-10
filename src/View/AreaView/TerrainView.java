package View.AreaView;

import Configs.SpriteSizes;
import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TerrainView extends Viewport {

    private Image terrainImage;

    public TerrainView(Image terrainImage){
        this.terrainImage = terrainImage;
    }

    @Override
    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.drawImage(terrainImage, x*SpriteSizes.TERRAIN_WIDTH, y*SpriteSizes.TERRAIN_WIDTH,
                SpriteSizes.TERRAIN_WIDTH, SpriteSizes.TERRAIN_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }
}
