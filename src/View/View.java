package View;

import Configs.ImagesInfo;
import Model.Map.MapBuilder.MapBuilder;

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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ImagesInfo.SCREEN_WIDTH, ImagesInfo.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        add(viewport);
        //add(decalView);
        setTitle("CLUBOOP");

        //setVisible(true);

    }

}
