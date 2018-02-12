package Model.Map;

import Controller.Controller.MainController;
import Controller.Utility.MapBuilder;
import View.AreaView.AreaViewPort;
import View.AreaView.MapView;
import View.Viewport;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    @Test
    void changeCurrentMapTo() {


        MapBuilder mapBuilder = new MapBuilder();
        MapView mapView1 = null;
        MapView mapView2 = null;
        MapView mapView3 = null;

        Map m1 = null;
        Map m2 = null;
        Map m3 = null;

        try {
            m1 = mapBuilder.buildMap("0001");
            mapView1 = mapBuilder.getViewport();

            m2 = mapBuilder.buildMap("0002");
            mapView2 = mapBuilder.getViewport();

            m3 = mapBuilder.buildMap("0003");
            mapView3 = mapBuilder.getViewport();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        World.getWorld().addMap("0001", m1, mapView1);
        World.getWorld().addMap("0002", m2, mapView2);
        World.getWorld().addMap("0003", m3, mapView3);

        World.getWorld().changeCurrentMapTo(m1);
        assertEquals(World.getWorld().getCurrentMap(), m1,"Current map should be m1");
    }
}