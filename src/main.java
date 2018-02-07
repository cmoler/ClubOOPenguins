import View.View;

import java.awt.*;

public class main {

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            View game = new View();
            game.setVisible(true);
        });
    }
}
