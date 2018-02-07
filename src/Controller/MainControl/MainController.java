package Controller.MainControl;

import Controller.Contexts.Context;
import Controller.Contexts.MenuContext;
import Controller.GameController.GameController;
import Controller.MainMenuControl.MainMenuController;
import View.Viewport;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.*;

public class MainController {

    private Input input;
    private Context activeContext;
    private OOPenguinGame game;

    private Viewport viewport;
    private GameController gameController;
    private MainMenuController mainMenuController;



    public MainController(){
        game = new OOPenguinGame();
        activeContext = new MenuContext();
        input = new Input(activeContext);
        game.addKeyListener(input);



    }

    public void setContext(Context context){

    }



    public static void main(String[] args){
        MainController mainController = new MainController();
        while(true){

        }
    }
}
