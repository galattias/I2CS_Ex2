package assignments.Ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private int[][] _map_3_3 = {{0,1,0}, {1,0,1}, {0,1,0}};
    private Map2D _m0;
    private Map2D _m1;

    @BeforeEach
    public void setup() {
        _m0 = new Map(_map_3_3);
        _m1 = new Map(10, 10, 0); // Initialize _m1
    }

    @Test
    void testInit() {
        assertEquals(3, _m0.getWidth());
        assertEquals(3, _m0.getHeight());

        _m1.init(_map_3_3);
        assertEquals(_m0.getWidth(), _m1.getWidth());
        assertEquals(1, _m1.getPixel(1, 0));
    }

    @Test
    void testEquals() {
        Map2D m2 = new Map(_map_3_3);
        assertTrue(_m0.equals(m2));

        m2.setPixel(0, 0, 99);
        assertFalse(_m0.equals(m2));
    }

    @Test
    void testFill() {
        Pixel2D p = new Index2D(0,0);
        // Fill the 10x10 map (value 0) with value 2
        int filled = _m1.fill(p, 2, false);
        assertEquals(100, filled);
    }

    @Test
    void testShortestPath() {
        Map2D map = new Map(5, 5, 0);
        Pixel2D p1 = new Index2D(0, 0);
        Pixel2D p2 = new Index2D(4, 0);
        Pixel2D[] path = map.shortestPath(p1, p2, 1, false);
        assertEquals(5, path.length);
    }
}