package Model.Map;

import org.junit.jupiter.api.Test;

import static Model.Map.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void adjacencyTest() {
        Map m = new Map(3, 3);

        //Test Adjacency of (0,0)
        Location l = m.getLocation(0,0);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (0,0)");
        assertEquals(l.getAdjacentAt(N), null,"There is no location N of (0,0)");
        assertEquals(l.getAdjacentAt(NE), null,"There is no location NE of (0,0)");
        assertEquals(l.getAdjacentAt(W), null,"There is no location W of (0,0)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(0,1),"The location (0,1) is E of (0,0)");
        assertEquals(l.getAdjacentAt(SW), null,"There is no location SW of (0,0)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(1,0),"The location (1,0) is S of (0,0)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(1,1),"The location (1,1) is SE of (0,0)");

        //Test Adjacency of (0,1)
        l = m.getLocation(0,1);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (0,1)");
        assertEquals(l.getAdjacentAt(N), null,"There is no location N of (0,1)");
        assertEquals(l.getAdjacentAt(NE), null,"There is no location NE of (0,1)");
        assertEquals(l.getAdjacentAt(W), m.getLocation(0,0),"The location (0,0) is W of (0,1)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(0,2),"The location (0,2) is E of (0,1)");
        assertEquals(l.getAdjacentAt(SW), m.getLocation(1,0),"The location (1,0) is SW of (0,1),1)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(1,1),"The location (1,1) is S of (0,1)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(1,2),"The location (1,2) is SE of (0,1)");

        //Test Adjacency of (0,2)
        l = m.getLocation(0,2);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (0,2)");
        assertEquals(l.getAdjacentAt(N), null,"There is no location N of (0,2)");
        assertEquals(l.getAdjacentAt(NE), null,"There is no location NE of (0,2)");
        assertEquals(l.getAdjacentAt(W), m.getLocation(0,1),"The location (0,1) is W of (0,2)");
        assertEquals(l.getAdjacentAt(E), null,"There is no location E of (0,2)");
        assertEquals(l.getAdjacentAt(SW), m.getLocation(1,1),"The location (1,1) is SW of (0,2)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(1,2),"The location (1,2) is S of (0,2)");
        assertEquals(l.getAdjacentAt(SE), null ,"There is no location SE of (0,2)");

        //Test Adjacency of (1,0)
        l = m.getLocation(1,0);

        assertEquals(l.getAdjacentAt(NW), null,"There is no location NW of (1,0)");
        assertEquals(l.getAdjacentAt(N), m.getLocation(0,0),"The location (0,0) is N of (1,0)");
        assertEquals(l.getAdjacentAt(NE), m.getLocation(0,1),"The location (0,1) is NE of (1,0)");
        assertEquals(l.getAdjacentAt(W), null,"There is no location W of (1,0)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(1,1),"The location (1,1) is E of (1,0)");
        assertEquals(l.getAdjacentAt(SW), null,"There is no location SW of (1,0)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(2,0),"The location (2,0) is S of (1,0)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(2,1) ,"The location (2,1) is SE of (1,0)");

        //Test Adjacency of (1,1)
        l = m.getLocation(1,1);

        assertEquals(l.getAdjacentAt(NW), m.getLocation(0,0),"The location (0,0) is NW of (1,1)");
        assertEquals(l.getAdjacentAt(N), m.getLocation(0,1),"The location (0,1) is N of (1,1)");
        assertEquals(l.getAdjacentAt(NE), m.getLocation(0,2),"The location (0,2) is NE of (1,1)");
        assertEquals(l.getAdjacentAt(W), m.getLocation(1,0),"The location (1,0) is W of (1,1)");
        assertEquals(l.getAdjacentAt(E), m.getLocation(1,2),"The location (1,2) is E of (1,1)");
        assertEquals(l.getAdjacentAt(SW), m.getLocation(2,0),"The location (2,0) is SW of (1,1),1)");
        assertEquals(l.getAdjacentAt(S), m.getLocation(2,1),"The location (2,1) is S of (1,1)");
        assertEquals(l.getAdjacentAt(SE), m.getLocation(2,2),"The location (2,2) is SE of (1,1)");

    }

}