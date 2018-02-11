package Controller.Contexts;

import Controller.Controller.Controller;
import java.awt.event.KeyEvent;
import Model.Map.Direction;


public abstract class Context {

    private KeyEvent lastEvent;
    private Controller controller;

    Context(Controller controller){
        this.controller = controller;
    }

    public final void processNumpadEvent(Direction direction){
        controller.handleNumpad(direction);
    }

    public final void setLastEvent(KeyEvent keyEvent){
        this.lastEvent = keyEvent;
    }

    public final KeyEvent getLastEvent(){
        return lastEvent;
    }

    public final void processKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();

        switch(keyCode){

            case KeyEvent.VK_ESCAPE:
                controller.handleEscape();
                break;

            case KeyEvent.VK_I:
                controller.handleI();
                break;

            case KeyEvent.VK_ENTER:
                controller.handleEnter();
                break;

        }
    }
}