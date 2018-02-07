package Controller.Contexts;

import java.awt.event.KeyEvent;

public class MenuContext extends Context{
    @Override
    public void processKeyEvent(KeyEvent event) {

        //ESCAPE
        if(event.getKeyCode() == 27){

            System.out.println("ESCAPE WAS PRESSED");
            //CLOSE MENU
            //SWITCH ACTIVECONTEXT TO GAMECONTEXT

        }

        System.out.println("KeyChar: " + event.getKeyChar() + "  | KeyCode: " + event.getKeyCode());
    }
}
