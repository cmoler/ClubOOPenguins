package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Viewport extends JPanel{

    private Graphics2D graphics2D;

    protected Viewport parent;
    protected List<Viewport> children;

    public void draw(Graphics2D graphics2D){
        for(Viewport child: children){
            child.draw(graphics2D);
        }
    }

    public void add(Viewport viewport){
        viewport.parent = this;
        children.add(viewport);
    }

    public void remove(Viewport viewport){
        for(Viewport child: children){
            viewport.parent = null;
            if(child == viewport) children.remove(child);
        }
    }

    public List<Viewport> getChildren(){

        return children;
    }

    public int getX(){
        return -1;
    }

    public int getY(){
        return -1;
    }

    public int getWidth(){
        return -1;
    }

    public int getHeight(){
        return -1;
    }

    public void update(){

    }
}
