package Controller.Contexts;

import Controller.Controller.Controller;
import java.awt.event.KeyEvent;
import Model.Map.Direction;


public abstract class Context {

    private Controller controller;

    Context(Controller controller){
        this.controller = controller;
    }

    public final void processNumpadEvent(Direction direction){
        controller.handleNumpad(direction);
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

            case KeyEvent.VK_T:
                controller.handleT();

        }
    }
}