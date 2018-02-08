package Model.Map.MapBuilder;

import Model.Map.Map;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MapBuilderTest {

    @Test
    void makeMap() throws FileNotFoundException {
        MapBuilder b = new MapBuilder();
        Map m = b.buildMap("0001");
    }
}