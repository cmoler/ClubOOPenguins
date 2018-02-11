package Controller.EntityBuilder;

import Controller.Utility.EntityBuilder;
import Model.Entity.Entity;
import Model.Item.TakeableItem;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class EntityBuilderTest {

    @Test
    void buildEntity() throws FileNotFoundException {
        EntityBuilder eb = new EntityBuilder();
        Entity e = eb.buildEntity("0001");
    }
}