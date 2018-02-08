package View.StatusView;


import Configs.Commons;
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

    private final int ENTITY_EXP_X = 40;
    private final int ENTITY_EXP_Y = 40;
    private final int ENTITY_EXP_HEIGHT = 40;
    private final int ENTITY_EXP_WIDTH = 40;

    private final int ENTITY_LEVEL_X = 90;
    private final int ENTITY_LEVEL_Y = 90;
    private final int ENTITY_LEVEL_WIDTH = 10;
    private final int ENTITY_LEVEL_HEIGHT = 10;

    private Entity entity;

    public StatsView(Entity entity){
        this.entity = entity;
        entity.attach(this);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        //Portion of HP
        double percentHP = entity.getHealth()/100;
        int hprectSize = (int) (percentHP * ENTITY_HEALTH_WIDTH);

        //Needed XP vars
        int expNeeded = entity.getExperienceForNextLevel();
        int prevExp = entity.getExperienceForCurrentLevel();
        int exp = entity.getExperience();
        int getLevel = entity.getLevel();

        //Portion of XP
        double percentEXP = (expNeeded-prevExp)/(exp-prevExp);
        int xprectsize = (int) (percentEXP * ENTITY_EXP_WIDTH);

        //Load Interfrace
        graphics2D.drawImage(Commons.RUNESCAPE_GUI,0,0, Commons.SCREEN_WIDTH, Commons.SCREEN_HEIGHT);

        //HPBAR
        graphics2D.setColor(new Color(233, 3, 3));
        graphics2D.drawRect(ENTITY_HEALTH_X, ENTITY_HEALTH_Y, ENTITY_HEALTH_WIDTH, ENTITY_HEALTH_HEIGHT);
        graphics2D.drawRect(ENTITY_HEALTH_X + (ENTITY_HEALTH_WIDTH-hprectSize), ENTITY_HEALTH_Y, hprectSize, ENTITY_HEALTH_HEIGHT);

        //EXPBAR
        graphics2D.setColor(new Color(3, 3, 233));
        graphics2D.drawRect(ENTITY_EXP_X, ENTITY_EXP_Y, ENTITY_EXP_WIDTH, ENTITY_EXP_HEIGHT);
        graphics2D.drawRect(ENTITY_EXP_X + (ENTITY_EXP_WIDTH-xprectsize), ENTITY_EXP_Y, xprectsize, ENTITY_EXP_HEIGHT);

        graphics2D.drawOval(ENTITY_LEVEL_X, ENTITY_LEVEL_Y, ENTITY_LEVEL_WIDTH, ENTITY_LEVEL_HEIGHT);
        graphics2D.drawString("" + getLevel,  ENTITY_LEVEL_X + ENTITY_LEVEL_WIDTH/2, ENTITY_LEVEL_Y + ENTITY_LEVEL_HEIGHT/2);
//      graphics2D.drawString("entity.getHealth()", (ENTITY_HEALTH_X + ENTITY_HEALTH_HEIGHT)/2, (ENTITY_HEALTH_Y + ENTITY_HEALTH_WIDTH)/2);
//      graphics2D.drawString("entity.getEXP()", (ENTITY_EXP_X + ENTITY_EXP_HEIGHT)/2, (ENTITY_EXP_Y + ENTITY_EXP_WIDTH)/2);

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
