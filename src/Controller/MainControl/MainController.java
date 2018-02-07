package Controller.MainControl;

import Controller.Contexts.Context;
import Controller.GameController.GameController;
import Controller.MainMenuControl.MainMenuController;
import View.Viewport;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.*;

public class MainController {

    private Input input;
    private Context context;
    private OOPenguinGame game;

    private Viewport viewport;
    private GameController gameController;
    private MainMenuController mainMenuController;



    public MainController(){
        game = new OOPenguinGame();
        input = new Input();
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
