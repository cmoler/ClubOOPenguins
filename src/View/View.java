package View;

import Configs.Commons;
import Controller.Utility.EntityBuilder;
import Controller.Utility.MapBuilder;

import javax.swing.*;
import java.io.FileNotFoundException;

public class View extends JFrame {


    public View(){
        initUI();
    }

    private void initUI() {

        // TODO: this location constructor is just to get rid of errors
        MapBuilder mapBuilder = new MapBuilder();
        try {
            mapBuilder.buildMap("0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Viewport viewport = mapBuilder.getViewport();

        EntityBuilder entityBuilder = new EntityBuilder();

        Viewport avatarView = entityBuilder.getAvatarView();
        Viewport statusView = entityBuilder.getStatusViewport();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.SCREEN_WIDTH, Commons.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        add(viewport);
        add(avatarView);
        add(statusView);
        //add(decalView);
        setTitle("CLUBOOP");

        //setVisible(true);

    }

}
