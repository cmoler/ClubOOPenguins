package View;

import Configs.Commons;
import Model.Map.Location;
import View.AreaView.DecalView;
import View.AreaView.LocationView;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {


    public View(){
        initUI();
    }


    private void initUI() {

        Location location = new Location();
        Viewport locationView = new LocationView(location, 250, 250);

        DecalView decalView = new DecalView("resources/bluePenguin.png");
        locationView.add(decalView);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        add(locationView);
        //add(decalView);
        setTitle("CLUBOOP");

        //setVisible(true);

    }

}
