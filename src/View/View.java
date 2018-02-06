package View;

import Configs.Commons;

import javax.swing.*;

public class View extends JFrame {


    public View(Viewport viewport){

        initUI(viewport);
    }

    private void initUI(Viewport viewport) {

        add(viewport);
        setTitle("CLUBOOP");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

}
