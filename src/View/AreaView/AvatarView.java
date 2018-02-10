package View.AreaView;


import Configs.ImagesInfo;
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
    private int velocity = 10;

    public AvatarView(Entity entity, int x, int y){
        avatarImage = ImagesInfo.AVATAR_IMAGE;
        this.entity = entity;
        entity.attach(this);
        this.x = x;
         this.y = y;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
       graphics2D.drawImage(avatarImage, x, y,
               10, 10,this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

    @Override
    public void moveUpdate(Direction direction){
        switch(direction){
            case N:
                y += velocity;
                break;
            case NE:
                y += velocity/2;
                x += velocity/2;
                break;
            case E:
                x += velocity;
                break;
            case SE:
                y -= velocity/2;
                x += velocity;
                break;
            case S:
                y -= velocity;
                break;
            case SW:
                y -= velocity/2;
                x -= velocity/2;
                break;
            case W:
                x -= velocity;
                break;
            case NW:
                y += velocity/2;
                x -= velocity/2;
                break;
        }
    }
}
