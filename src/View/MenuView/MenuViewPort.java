package View.MenuView;

import Configs.TextBoxInfo;
import View.Viewport;

import java.awt.*;


public class MenuViewPort extends Viewport {

    public MenuViewPort(int startX, int startY){
        add(new SaveGameView(startX, startY));
        add(new LoadGameView(startX, startY+ TextBoxInfo.TEXTBOX_HEIGHT));
        add(new ExitGameView(startX, startY + 2*TextBoxInfo.TEXTBOX_HEIGHT));
    }

}
