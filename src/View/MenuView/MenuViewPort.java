package View.MenuView;

import Configs.Commons;
import Configs.TextBoxInfo;
import View.Viewport;

import java.awt.*;


public class MenuViewPort extends Viewport {

    public MenuViewPort(){
        int startX = Configs.Commons.SCREEN_WIDTH/2;
        int startY = Commons.SCREEN_HEIGHT/4;
        add(new SaveGameView(startX, startY));
        add(new LoadGameView(startX, startY+ TextBoxInfo.TEXTBOX_HEIGHT));
        add(new ExitGameView(startX, startY + 2*TextBoxInfo.TEXTBOX_HEIGHT));
    }

}
