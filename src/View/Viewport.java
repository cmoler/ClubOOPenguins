package View;


import java.awt.*;
import java.util.List;

public abstract class Viewport {

    private Graphics2D graphics2D;

    private List<Viewport> children;

    public abstract void draw(Graphics2D graphics2D);

    public void add(Viewport viewport){
        children.add(viewport);
    }

    public void remove(Viewport viewport){
        for(Viewport child: children){
            if(child == viewport) children.remove(child);
        }
    }

    public List<Viewport> getChildren(){

        return children;
    }

    public void update(){

    }
}
