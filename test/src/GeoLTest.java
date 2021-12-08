
import api.Implementation.GeoL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoLTest {

    GeoL g1 = new GeoL(0, 1.3118716362419698, 16);
    GeoL g2 = new GeoL(0, 1.232037506070033, 1);
    GeoL g3 = new GeoL(1, 1.8635670623870366, 0);
    GeoL g4 = new GeoL(1, 1.8015954015822042, 2);
    GeoL g5 = new GeoL(2, 1.5784991011275615, 1);

    @Test
    void x() {
        assertEquals(0, g1.x());
        assertEquals(0, g2.x());
        assertEquals(1, g3.x());
        assertEquals(1, g4.x());
        assertEquals(2, g5.x());
    }

    @Test
    void y() {
        assertEquals(1.3118716362419698, g1.y());
        assertEquals(1.232037506070033, g2.y());
        assertEquals(1.8635670623870366, g3.y());
        assertEquals(1.8015954015822042, g4.y());
        assertEquals(1.5784991011275615, g5.y());
    }

    @Test
    void z() {
        assertEquals(16, g1.z());
        assertEquals(1, g2.z());
        assertEquals(0, g3.z());
        assertEquals(2, g4.z());
        assertEquals(1, g5.z());
    }

    @Test
    void distance() {
        assertEquals(g1.distance(g2), 15.00021244810687);
        assertEquals(g2.distance(g3), 1.5488155411481226);
        assertEquals(g3.distance(g4), 2.000959891337882);
        assertEquals(g4.distance(g5), 1.4317024688379036);
    }
}