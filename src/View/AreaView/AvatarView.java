package View.AreaView;


import Configs.ImagesInfo;
import Configs.SpriteSizes;
import Model.Map.Direction;
import Model.Entity.Entity;
import View.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AvatarView extends Viewport {

    private Image avatarImage;
    private Entity entity;
    private int x;
    private int y;
    private int velocity = 1;

    public AvatarView(Entity entity, int x, int y){
        avatarImage = ImagesInfo.AVATAR_IMAGE;
        this.entity = entity;
        entity.attach(this);
        this.x = x;
        this.y = y;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
       graphics2D.drawImage(avatarImage, x* SpriteSizes.TERRAIN_WIDTH + SpriteSizes.TERRAIN_WIDTH/4, y*SpriteSizes.TERRAIN_HEIGHT + SpriteSizes.TERRAIN_HEIGHT/4,
               75, 75,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

    @Override
    public void moveUpdate(Direction direction){
        switch(direction){
            case N:
                y -= velocity;
                break;
            case NE:
                y -= velocity;
                x += velocity;
                break;
            case E:
                x += velocity;
                break;
            case SE:
                y += velocity;
                x += velocity;
                break;
            case S:
                y += velocity;
                break;
            case SW:
                y += velocity;
                x -= velocity;
                break;
            case W:
                x -= velocity;
                break;
            case NW:
                y -= velocity;
                x -= velocity;
                break;
        }
    }
}
