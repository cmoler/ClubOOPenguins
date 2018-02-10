package Model.Map;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EntityBuilderTest {

    @Test
    void buildEntity() throws FileNotFoundException {
        EntityBuilder eb = new EntityBuilder();
        eb.buildEntity("0001");
    }
}