package Model.Map.MapBuilder;

import Controller.Utility.MapBuilder;
import Model.Map.Map;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class MapBuilderTest {

    @Test
    void makeMap() throws FileNotFoundException {
        MapBuilder b = new MapBuilder();
        Map m = b.buildMap("0001");
        m = b.buildMap("0002");
    }
}