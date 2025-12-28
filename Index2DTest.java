package assignments.Ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Index2DTest {

    @Test
    public void testCoordinates() {
        Index2D p = new Index2D(5, 10);
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }

    @Test
    public void testDistance() {
        Index2D p1 = new Index2D(0, 0);
        Index2D p2 = new Index2D(3, 4);
        assertEquals(5.0, p1.distance2D(p2), 0.001);
    }

    @Test
    public void testEquals() {
        Index2D p1 = new Index2D(1, 1);
        Index2D p2 = new Index2D(1, 1);
        Index2D p3 = new Index2D(2, 2);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }
}