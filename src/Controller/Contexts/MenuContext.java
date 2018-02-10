package Controller.Contexts;

import Controller.Controller.MenuController;

import java.awt.event.KeyEvent;

public class MenuContext extends Context{

    private MenuController menuController;

    public MenuContext(MenuController menuController){
        this.menuController = menuController;
    }

    @Override
    public void processKeyEvent(KeyEvent event) {

    }
}