package View;

import Configs.Commons;
import Model.Item.Item;
import Model.Map.AreaEffect.DamageAreaEffect;
import Model.Map.Location;
import Model.Map.Terrain.Glacier;
import View.AreaView.DecalView;
import View.AreaView.LocationView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {


    public View(){
        initUI();
    }

    private void initUI() {

        // TODO: this location constructor is just to get rid of errors
        Location location = new Location(new Glacier(), false, new DamageAreaEffect(), new ArrayList<Item>());
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
