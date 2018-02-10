package Configs;

import java.awt.*;

public class Commons {
    public static final int SCREEN_WIDTH  = 1920;
    public static final int SCREEN_HEIGHT = 1080;
    public static final int TILE_WIDTH = 200;
    public static final int TILE_HEIGHT = 200;
    public static final String TILE_SHEET = "resources/images/terrain.png";
    public static final String AREAEFFECT_DAMAGE_FILELOCATION = "resources/images/Red_AOE.png";
    public static final String AREAEFFECT_HEAL_FILELOCATION = "resources/images/Green_AOE.png";
    public static final String AREAEFFECT_KILL_FILELOCATION = "resources/images/Black_AOE.png";
    public static final String AREAEFFECT_LEVELUP_FILELOCATION = "resources/images/Blue_AOE.png";
    public static final String ITEM_ITERACTIVE_FILELOCATION = "resources/images/Moss_Key_Pin.png";
    public static final String ITEM_ONESHOT_FILELOCATION = "resources/images/Fishburger.png";
    public static final String ITEM_TAKEABLE_FILELOCATION= "resources/images/Blue_Bunny_Ears.png";
    public static final String ITEM_TELEPORTER_FILELOCATION = "resources/images/Portal_box.png";
    public static final String RUNESCAPE_GUI_FILELCOATION = "resources/images/Interface.png";

    public static final Image ICE_IMAGE = SpriteParser.getSpriteParser().getIceImage();
    public static final Image WATER_IMAGE = SpriteParser.getSpriteParser().getWaterImage();
    public static final Image GLACIER_IMAGE = SpriteParser.getSpriteParser().getGlacierImage();
    public static final Image OBSTACLE_IMAGE = SpriteParser.getSpriteParser().getObstacleItemImage();

    public static final Image AREAEFFECT_DAMAGE_IMAGE = SpriteParser.getSpriteParser().getAreaEffectDamageImage();
    public static final Image AREAEFFECT_HEAL_IMAGE = SpriteParser.getSpriteParser().getAreaEffectHealImage();
    public static final Image AREAEFFECT_KILL_IMAGE = SpriteParser.getSpriteParser().getAreaEffectKillImage();
    public static final Image AREAEFFECT_LEVELUP_IMAGE = SpriteParser.getSpriteParser().getAreaEffectLevelUpImage();

    public static final Image ITEM_ITERACTIVE_IMAGE = SpriteParser.getSpriteParser().getInteractiveItemImage();
    public static final Image ITEM_ONESHOT_IMAGE = SpriteParser.getSpriteParser().getOneShotItemImage();
    public static final Image ITEM_TAKEABLE_IMAGE = SpriteParser.getSpriteParser().getTakeAbleItemImage();
    public static final Image ITEM_TELEPORTER_IMAGE = SpriteParser.getSpriteParser().getTeleporterItemImage();






}
