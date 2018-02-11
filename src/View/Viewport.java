package View;

import Model.Map.Direction;
import View.StatusView.StatusViewPort;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Viewport extends JPanel {

    Timer timer;

    protected Viewport parent;
    protected List<Viewport> children = new ArrayList<Viewport>();

    public Viewport(){

        setFocusable(true);
        setDoubleBuffered(true);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
    }

    public int getLocationX() {
        return -1;
    }

    public int getLocationY() {
        return -1;
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            repaint();
        }
    }

    @Override
    public void addNotify() {

        super.addNotify();
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

    public void draw(Graphics2D graphics2D) {
        for (Viewport child : children) {
            child.draw(graphics2D);
        }
    }

    public void draw(Graphics2D graphics2D, int x, int y){
        for(Viewport child: children){
            child.draw(graphics2D, x, y);
        }
    }

    public void setSelectedMenuView(int selectedMenuView){
        for(Viewport child: children){
            child.setSelectedMenuView(selectedMenuView);
        }
    }

    public void setRenderOption(StatusViewPort.RenderOption renderOption){
        for(Viewport child: children){
            child.setRenderOption(renderOption);
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

    public void update(){
        repaint();
    }

    public void moveCursor(int index){}

    public void moveUpdate(Direction direction){
        for(Viewport child: children){
            child.moveUpdate(direction);
        }
    }
}
