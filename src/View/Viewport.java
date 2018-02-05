package View;

import Configs.Commons;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Viewport extends JPanel implements Commons {

    Timer timer;

    protected Viewport parent;
    protected List<Viewport> children = new ArrayList<Viewport>();

    public Viewport(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        draw(graphics2D);

        Toolkit.getDefaultToolkit().sync();
    }

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
