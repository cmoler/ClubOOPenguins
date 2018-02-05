package View;

import Model.Map.Location;
import View.AreaView.LocationView;
import View.AreaView.DecalView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class LocationViewTests {

    @Test
    public void locationAppears(){

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
}
