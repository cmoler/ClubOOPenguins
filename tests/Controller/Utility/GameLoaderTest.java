package Controller.Utility;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GameLoaderTest {

    @Test
    void loadEntity() {
    }

    @Test
    void loadMap() {
    }

    @Test
    void loadGame() throws FileNotFoundException {
        GameLoader gl = new GameLoader();
        GameSaver gs = new GameSaver();

        gl.loadGame();

//        gs.SaveGame(entity, m, inventory, equipment);
    }
}