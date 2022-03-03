package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testCreatePoint() {
        int x = 2;
        int y = 2;

        Point p = new Point(2,2);
        assertEquals(x,p.x);
        assertEquals(y,p.y);
    }

    @Test
    void testCreatePointError() {
        int x = 3;

        Point p = new Point(2,2);
        assertNotEquals(x,p.x);
    }

}