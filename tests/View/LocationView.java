package View;

import Model.Map.Location;
import View.AreaView.DecalView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class LocationView {

    @Test
    public void locationAppears(){

        Location location = new Location();
        View.AreaView.LocationView locationView = new View.AreaView.LocationView(location, 1, 1);

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
