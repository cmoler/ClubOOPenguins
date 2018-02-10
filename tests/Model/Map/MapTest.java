package Model.Map;

import org.junit.jupiter.api.Test;

import static Model.Map.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void adjacencyTest() {
        Map m = new Map(3, 3);
        Location l = m.getLocation(0,0);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (0,0)");
        assertEquals(l.getAdjacentAt(N), null,"There is no location N of (0,0)");
        assertEquals(l.getAdjacentAt(NE), null,"There is no location NE of (0,0)");
        assertEquals(l.getAdjacentAt(W), null,"There is no location W of (0,0)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(0,1),"The location (0,1) is E of (0,0)");
        assertEquals(l.getAdjacentAt(SW), null,"There is no location SW of (0,0)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(1,0),"The location (1,0) is S of (0,0)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(1,1),"The location (1,1) is SE of (0,0)");

        l = m.getLocation(0,1);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (0,1)");
        assertEquals(l.getAdjacentAt(N), null,"There is no location N of (0,1)");
        assertEquals(l.getAdjacentAt(NE), null,"There is no location NE of (0,1)");
        assertEquals(l.getAdjacentAt(W), null,"There is no location W of (0,1)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(0,1),"The location (0,1) is E of (0,1)");
        assertEquals(l.getAdjacentAt(SW), null,"There is no location SW of (0,1)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(1,0),"The location (1,0) is S of (0,1)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(1,1),"The location (1,1) is SE of (0,1)");

    }

}