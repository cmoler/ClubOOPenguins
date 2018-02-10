package Controller.Input;

import Controller.Contexts.Context;
import Model.Map.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private Context activeContext;

    public Input(Context activeContext) {
        this.activeContext = activeContext;
    }

    public void setActiveContext(Context context){
        this.activeContext = context;
    }

    private void forwardKeyEvent(KeyEvent event){
        activeContext.processKeyEvent(event);
    }

    private void forwardNumPadEvent(KeyEvent event){

        switch(event.getKeyCode()){
            case KeyEvent.VK_NUMPAD1:
                activeContext.processNumpadEvent(Direction.SW);
                break;

            case KeyEvent.VK_NUMPAD2:
                activeContext.processNumpadEvent(Direction.S);
                break;

            case KeyEvent.VK_NUMPAD3:
                activeContext.processNumpadEvent(Direction.SE);
                break;

            case KeyEvent.VK_NUMPAD4:
                activeContext.processNumpadEvent(Direction.W);
                break;

            case KeyEvent.VK_NUMPAD6:
                activeContext.processNumpadEvent(Direction.E);
                break;

            case KeyEvent.VK_NUMPAD7:
                activeContext.processNumpadEvent(Direction.NW);
                break;

            case KeyEvent.VK_NUMPAD8:
                activeContext.processNumpadEvent(Direction.N);
                break;

            case KeyEvent.VK_NUMPAD9:
                activeContext.processNumpadEvent(Direction.NE);
                break;

            default:
                return;

        }

    }

    public void keyPressed(KeyEvent event) {

        int keyCode = event.getKeyCode();

        if(keyCode >= KeyEvent.VK_NUMPAD1 && keyCode <= KeyEvent.VK_NUMPAD9){
            forwardNumPadEvent(event);
        }

        else{
            forwardKeyEvent(event);
        }

    }

    public void keyTyped(KeyEvent event) {
        return;
    }

    public void keyReleased(KeyEvent event) {
        return;
    }
}
