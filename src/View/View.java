package View;

import Configs.Commons;
import Model.Map.Location;
import View.AreaView.DecalView;
import View.AreaView.LocationView;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {


    public View(){
        Location location = new Location();
        LocationView locationView = new LocationView(location, 1, 1);

        DecalView decalView = new DecalView("resources/Interface.png");
        locationView.add(decalView);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                View game = new View(locationView);
                game.setVisible(true);

            }
        });
    }

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
