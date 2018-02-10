package View.AreaView.ItemView;


import Configs.SpriteSizes;
import Model.Map.Location;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemView extends Viewport {

    private Image itemImage;

    public ItemView(){

    }

    public ItemView(Image image){
        this.itemImage = image;
    }

    @Override
    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.drawImage(itemImage, (x*SpriteSizes.TERRAIN_WIDTH)+(SpriteSizes.TERRAIN_WIDTH/4), (y*SpriteSizes.TERRAIN_HEIGHT)+(SpriteSizes.TERRAIN_HEIGHT/4),
                SpriteSizes.ITEM_WIDTH, SpriteSizes.ITEM_HEIGHT,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

}
