package Controller.Input;

import Controller.Contexts.Context;
import Model.Map.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

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
            case KeyEvent.VK_1:
            case KeyEvent.VK_Z:
                activeContext.processNumpadEvent(Direction.SW);
                break;

            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_2:
            case KeyEvent.VK_X:
                activeContext.processNumpadEvent(Direction.S);
                break;

            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_3:
            case KeyEvent.VK_C:
                activeContext.processNumpadEvent(Direction.SE);
                break;

            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_4:
            case KeyEvent.VK_A:
                activeContext.processNumpadEvent(Direction.W);
                break;

            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_6:
            case KeyEvent.VK_D:
                activeContext.processNumpadEvent(Direction.E);
                break;

            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_7:
            case KeyEvent.VK_Q:
                activeContext.processNumpadEvent(Direction.NW);
                break;


            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_8:
            case KeyEvent.VK_W:
                activeContext.processNumpadEvent(Direction.N);
                break;

            case KeyEvent.VK_NUMPAD9:
            case KeyEvent.VK_9:
            case KeyEvent.VK_E:
                activeContext.processNumpadEvent(Direction.NE);
                break;

            default:
                return;

        }

    }

    public void keyPressed(KeyEvent event) {

        int keyCode = event.getKeyCode();

        boolean keyCodeAlternate = (keyCode == KeyEvent.VK_Q
                                    || keyCode == KeyEvent.VK_W
                                    || keyCode == KeyEvent.VK_E
                                    || keyCode == KeyEvent.VK_D
                                    || keyCode == KeyEvent.VK_C
                                    || keyCode == KeyEvent.VK_X
                                    || keyCode == KeyEvent.VK_Z
                                    || keyCode == KeyEvent.VK_A);

        if(keyCode >= KeyEvent.VK_NUMPAD1 && keyCode <= KeyEvent.VK_NUMPAD9){
            forwardNumPadEvent(event);
        }
        else if(keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_9){
            forwardNumPadEvent(event);
        }
        else if(keyCodeAlternate){
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
