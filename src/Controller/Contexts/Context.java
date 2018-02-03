package Controller.Contexts;

import Controller.MainControl.Input;
import Controller.MainControl.MainController;

public abstract class Context {

    private MainController mainController;

    public abstract void processInput(Input input);

}
