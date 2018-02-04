package View.AreaView;


import View.Viewport;

import java.awt.*;
import java.util.List;

public class AvatarView extends Viewport {

    private Image avatarImage;
    private Entity entity;

    public AvatarView(String fileName, Entity entity){
        ImageIcon imageIcon = new ImageIcon("fileName");
        avatarImage = imageIcon.getImage();
        this.entity = entity;
        entity.attach(this);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(avatarImage, entity.getX(), entity.getY(),
                entity.getWidth(), entity.getHeight(),this );
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

    @Override
    public void update(){
        repaint();
    }
}
