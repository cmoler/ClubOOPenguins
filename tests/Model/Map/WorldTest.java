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

        Map one = new Map(5, 5);
        Map two = new Map(10, 10);
        World.getWorld().changeCurrentMapTo(one, false);
        assertEquals(World.getWorld().getCurrentMap(), one, "Current map should be one");
        World.getWorld().changeCurrentMapTo(two, false);
        assertEquals(World.getWorld().getCurrentMap(), two, "Current map should now be two");
    }
}