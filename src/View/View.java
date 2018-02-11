package View;

import Configs.Commons;
import Controller.Utility.EntityBuilder;
import Controller.Utility.MapBuilder;
import View.AreaView.AvatarView;
import View.AreaView.MapView;
import View.MenuView.MenuViewPort;
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
            mapBuilder.buildMap("Default","0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MapView mapView = mapBuilder.getViewport();

        EntityBuilder entityBuilder = new EntityBuilder();
        try {
            entityBuilder.buildEntity("Default", "0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AvatarView avatarView = entityBuilder.getAvatarView();
        StatusViewPort statusView = entityBuilder.getStatusViewport();
        statusView.setRenderOption(StatusViewPort.RenderOption.INVENTORY);


        mapView.setEntity(avatarView.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView);
        viewport.add(avatarView);
        viewport.add(statusView);


        MenuViewPort menuViewPort = new MenuViewPort();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.SCREEN_WIDTH, Commons.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        add(menuViewPort);
        //add(decalView);
        setTitle("CLUBOOP");

        //setVisible(true);

    }

}
