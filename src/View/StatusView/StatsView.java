package View.StatusView;


import Configs.Commons;
import Configs.ImagesInfo;
import Configs.TextBoxInfo;
import Model.Entity.Entity;
import View.Viewport;

import java.awt.*;
import java.util.List;

public class StatsView extends Viewport {

    private final int ENTITY_HEALTH_X = (int) (Commons.SCREEN_WIDTH * 20.0/765.0);
    private final int ENTITY_HEALTH_Y = (int) (Commons.SCREEN_HEIGHT * 360.0/501.0);
    private final int ENTITY_HEALTH_HEIGHT = 20;
    private final int ENTITY_HEALTH_WIDTH = 500;

    private final int ENTITY_EXP_X = ENTITY_HEALTH_X;
    private final int ENTITY_EXP_Y = ENTITY_HEALTH_Y + 2 * ENTITY_HEALTH_HEIGHT;
    private final int ENTITY_EXP_HEIGHT = ENTITY_HEALTH_HEIGHT;
    private final int ENTITY_EXP_WIDTH = ENTITY_HEALTH_WIDTH;

    private final int ENTITY_LEVEL_X =    (int) (Commons.SCREEN_WIDTH * 625.0/765.0);
    private final int ENTITY_LEVEL_Y =    (int) (Commons.SCREEN_HEIGHT * 80.0/501.0);
    private final int ENTITY_LEVEL_WIDTH = 200;
    private final int ENTITY_LEVEL_HEIGHT = 200;

    private Entity entity;

    public StatsView(Entity entity){
        this.entity = entity;
        entity.attach(this);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        //Portion of HP
        double percentHP = 1 - entity.getHealth()/100.0;
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
        graphics2D.drawImage(ImagesInfo.RUNESCAPE_GUI,0,0, Commons.SCREEN_WIDTH, Commons.SCREEN_HEIGHT, this);

        //HPBAR
        graphics2D.setColor(new Color(233, 3, 3));
        graphics2D.fillRect(ENTITY_HEALTH_X, ENTITY_HEALTH_Y, ENTITY_HEALTH_WIDTH, ENTITY_HEALTH_HEIGHT);
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.fillRect(ENTITY_HEALTH_X + (ENTITY_HEALTH_WIDTH-hprectSize), ENTITY_HEALTH_Y, hprectSize, ENTITY_HEALTH_HEIGHT);

        //EXPBAR
        graphics2D.setColor(new Color(3, 3, 233));
        graphics2D.fillRect(ENTITY_EXP_X, ENTITY_EXP_Y, ENTITY_EXP_WIDTH, ENTITY_EXP_HEIGHT);
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.fillRect(ENTITY_EXP_X + (ENTITY_EXP_WIDTH-xprectsize), ENTITY_EXP_Y, xprectsize, ENTITY_EXP_HEIGHT);

        //level indicator
        //graphics2D.setColor(new Color(200, 200, 200));
        //graphics2D.drawOval(ENTITY_LEVEL_X, ENTITY_LEVEL_Y, ENTITY_LEVEL_WIDTH, ENTITY_LEVEL_HEIGHT);
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.setFont(new Font("Calibri",2,70));
        graphics2D.drawString("" + getLevel,  ENTITY_LEVEL_X , ENTITY_LEVEL_Y );
//      graphics2D.drawString("entity.getHealth()", (ENTITY_HEALTH_X + ENTITY_HEALTH_HEIGHT)/2, (ENTITY_HEALTH_Y + ENTITY_HEALTH_WIDTH)/2);
//      graphics2D.drawString("entity.getEXP()", (ENTITY_EXP_X + ENTITY_EXP_HEIGHT)/2, (ENTITY_EXP_Y + ENTITY_EXP_WIDTH)/2);


        if(entity.getHealth() == 0){
            graphics2D.setColor(new Color(233, 3, 3));
            graphics2D.setFont(new Font("Calibri",2,150));
            graphics2D.drawString("Game Over Dude", (int)(Commons.SCREEN_WIDTH * 100.0/765.0), (int) (Commons.SCREEN_HEIGHT * 250.0/501.0));

        }
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
