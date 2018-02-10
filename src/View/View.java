package View;

import Configs.Commons;
import Controller.Utility.EntityBuilder;
import Controller.Utility.MapBuilder;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.StatusView.StatusViewPort;

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
        MapView mapView = mapBuilder.getViewport();

        EntityBuilder entityBuilder = new EntityBuilder();
        try {
            entityBuilder.buildEntity("0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AvatarView avatarView = entityBuilder.getAvatarView();
        StatusViewPort statusView = entityBuilder.getStatusViewport();
        statusView.setRenderOption(StatusViewPort.RenderOption.INVENTORY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.SCREEN_WIDTH, Commons.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        mapView.setEntity(avatarView.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView);
        viewport.add(avatarView);
        viewport.add(statusView);

        add(viewport);
        //add(decalView);
        setTitle("CLUBOOP");

        //setVisible(true);

    }

}
