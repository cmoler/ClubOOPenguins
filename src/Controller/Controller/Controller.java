package Controller.Controller;

import View.Viewport;

public abstract class Controller {

    private Viewport view;

    public abstract void handleEscape();
    public abstract void handleNorth();
    public abstract void handleSouth();
    public abstract void handleWest();
    public abstract void handleEast();
    public abstract void handleNorthEast();
    public abstract void handleNorthWest();
    public abstract void handleSouthEast();
    public abstract void handleSouthWest();

}