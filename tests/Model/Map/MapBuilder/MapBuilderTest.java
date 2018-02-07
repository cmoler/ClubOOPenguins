package Model.Map.MapBuilder;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MapBuilderTest {

    @Test
    void ShouldPrintMapFile() throws FileNotFoundException {
        MapBuilder b = new MapBuilder();
        b.buildMap("0001");
    }
}