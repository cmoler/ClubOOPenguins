package View.MenuView;

import Configs.Commons;
import Configs.ImagesInfo;
import Configs.TextBoxInfo;
import View.Viewport;

import java.awt.*;


public class MenuViewPort extends Viewport {

    private Image selected = ImagesInfo.AREAEFFECT_LEVELUP_IMAGE;
    private int selectedX = Configs.Commons.SCREEN_WIDTH/2;
    private int selectedY;

    public MenuViewPort(){
        int startX = Configs.Commons.SCREEN_WIDTH/2;
        int startY = Commons.SCREEN_HEIGHT/4;

        this.selectedY = startY;

        add(new SaveGameView(startX, startY));
        add(new LoadGameView(startX, startY+ TextBoxInfo.TEXTBOX_HEIGHT));
        add(new ExitGameView(startX, startY + 2*TextBoxInfo.TEXTBOX_HEIGHT));
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        graphics2D.drawImage(selected, selectedX, selectedY, TextBoxInfo.TEXTBOX_WIDTH, TextBoxInfo.TEXTBOX_HEIGHT, this);
        super.draw(graphics2D);
    }

    @Override
    public void setSelectedMenuView(int selectedMenuView){
        switch (selectedMenuView){
            case 1:
                this.selectedY = Commons.SCREEN_HEIGHT/4;
                break;
            case 2:
                this.selectedY = Commons.SCREEN_HEIGHT/4 + TextBoxInfo.TEXTBOX_HEIGHT;
                break;
            case 3:
                this.selectedY = Commons.SCREEN_HEIGHT/4 + 2*TextBoxInfo.TEXTBOX_HEIGHT;
                break;
        }
    }
}
