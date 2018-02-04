package View.StatusView;


import Configs.TextBoxInfo;
import Model.Entity.Entity;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class StatsView extends Viewport {

    private final int ENTITY_HEALTH_X = 20;
    private final int ENTITY_HEALTH_Y = 20;
    private final int ENTITY_HEALTH_HEIGHT = 20;
    private final int ENTITY_HEALTH_WIDTH = 20;

    private final int ENTITY_EXP_X = 20;
    private final int ENTITY_EXP_Y = 20;
    private final int ENTITY_EXP_HEIGHT = 20;
    private final int ENTITY_EXP_WIDTH = 20;

    private Entity entity;

    public StatsView(Entity entity){
        this.entity = entity;
        entity.attach(this);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawString("entity.getHealth()", (ENTITY_HEALTH_X + ENTITY_HEALTH_HEIGHT)/2, (ENTITY_HEALTH_Y + ENTITY_HEALTH_WIDTH)/2);
        graphics2D.drawString("entity.getEXP()", (ENTITY_EXP_X + ENTITY_EXP_HEIGHT)/2, (ENTITY_EXP_Y + ENTITY_EXP_WIDTH)/2);
    }

    @Override
    public List<Viewport> getChildren(){
        return null;
    }

    @Override
    public void update(){

    }

}
