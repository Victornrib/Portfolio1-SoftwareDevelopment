package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CircleTest {

    @Test
    void testCreateCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p,radius);

        assertEquals(p.x,c.center.x);
        assertEquals(p.y,c.center.y);
        assertEquals(radius, c.radius);
    }

    @Test
    void testCreateCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p,3);

        assertNotEquals(radius, c.radius);
    }

}