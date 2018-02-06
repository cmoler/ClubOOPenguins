package View;

import Model.Map.Location;
import View.AreaView.LocationView;
import View.AreaView.DecalView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class LocationViewTests {

    @Test
    public void locationAppears(){

        View view = new View();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
