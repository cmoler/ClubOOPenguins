package View.MenuView;

import Configs.Commons;
import Configs.ImagesInfo;
import Configs.TextBoxInfo;
import View.Viewport;

import java.awt.*;


public class MenuViewPort extends Viewport {

    private Image selected = ImagesInfo.AREAEFFECT_LEVELUP_IMAGE;
    private int selectedX = Configs.Commons.SCREEN_WIDTH/2;
    private int selectedY = Commons.SCREEN_HEIGHT/4;

    public MenuViewPort(){
        int startX = Configs.Commons.SCREEN_WIDTH/2;
        int startY = Commons.SCREEN_HEIGHT/4;

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
        if(selectedMenuView == -1 && selectedY < Commons.SCREEN_HEIGHT/4 + 2*TextBoxInfo.TEXTBOX_HEIGHT)
            this.selectedY += TextBoxInfo.TEXTBOX_HEIGHT;
        else if(selectedMenuView == 1 && selectedY > Commons.SCREEN_HEIGHT/4)
                this.selectedY -= TextBoxInfo.TEXTBOX_HEIGHT;
    }
}
