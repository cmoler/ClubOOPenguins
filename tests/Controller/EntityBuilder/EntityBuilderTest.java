package Controller.EntityBuilder;

import Controller.Utility.EntityBuilder;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class EntityBuilderTest {

    @Test
    void buildEntity() throws FileNotFoundException {
        EntityBuilder eb = new EntityBuilder();
        eb.buildEntity("Default","0001");
    }
}