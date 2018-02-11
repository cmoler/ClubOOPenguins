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

/*
        mapBuilder = new MapBuilder();
        try {
            mapBuilder.buildMap("0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MapView mapView = mapBuilder.getViewport();

        entityBuilder = new EntityBuilder();
        try {
            entityBuilder.buildEntity("0001");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        AvatarView avatarView = entityBuilder.getAvatarView();

        StatusViewPort statusViewPort = entityBuilder.getStatusViewport();
        statusViewPort.setRenderOption(StatusViewPort.RenderOption.INVENTORY);

        mapView.setEntity(avatarView.getEntity());

        Viewport viewport = new Viewport();
        viewport.add(mapView);
        viewport.add(avatarView);
        viewport.add(statusViewPort);

        mainController.setAreaViewPort(viewport);
*/
    }

}
