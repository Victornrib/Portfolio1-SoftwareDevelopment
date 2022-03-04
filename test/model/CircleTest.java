package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class CircleTest {

    @Test
    void testCreateCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p,radius);

        assertEquals(p.x, c.center.x);
        assertEquals(p.y, c.center.y);
        assertEquals(radius, c.radius);
    }


    @Test
    void testCreateCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p,3);

        assertNotEquals(radius, c.radius);
    }


    @Test
    void testReturnCenterCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p, radius);

        assertEquals(p.x, c.returnCenter().x);
        assertEquals(p.y, c.returnCenter().y);
    }


    @Test
    void testReturnCenterCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Point q = new Point(2,2);
        Circle c = new Circle(q, radius);

        assertNotEquals(p.x, c.returnCenter().x);
        assertNotEquals(p.y, c.returnCenter().y);
    }


    @Test
    void testComputeAreaCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p, radius);
        Double expectedArea = Math.PI * Math.pow(5,2);

        assertEquals(expectedArea, c.computeArea());
    }


    @Test
    void testComputeAreaCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p, radius);
        Double expectedArea = Math.PI * Math.pow(5,3);

        assertNotEquals(expectedArea, c.computeArea());
    }


    @Test
    void testComputeAreaCircumferenceCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p, radius);
        Double expectedCircumference = 2 * Math.PI * radius;

        assertEquals(expectedCircumference, c.computeCircumference());
    }


    @Test
    void testComputeAreaCircumferenceCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Circle c = new Circle(p, radius);
        Double expectedCircumference = Math.PI * radius;

        assertNotEquals(expectedCircumference, c.computeCircumference());
    }


    @Test
    void testCheckPointInsideCircle() {
        int radius = 5;
        Point p = new Point(0,0);
        Point q = new Point(0,0);
        Circle c = new Circle(p, radius);

        assertEquals(true, c.checkPointInside(q));
    }


    @Test
    void testCheckPointInsideCircleError() {
        int radius = 5;
        Point p = new Point(0,0);
        Point q = new Point(6,0);
        Circle c = new Circle(p, radius);

        assertNotEquals(true, c.checkPointInside(q));
    }


    @Test
    void testComputeEuclideanDistanceToShape() {
        int radius1 = 5;
        int radius2 = 3;
        Point p = new Point(0,0);
        Point q = new Point(10,0);
        Circle c1 = new Circle(p, radius1);
        Circle c2 = new Circle(q, radius2);

        assertEquals(c1.computeEuclideanDistanceToAnotherShape(c2), 10);
    }


    @Test
    void testComputeEuclideanDistanceToShapeError() {
        int radius1 = 5;
        int radius2 = 3;
        Point p = new Point(0,0);
        Point q = new Point(4,0);
        Circle c1 = new Circle(p, radius1);
        Circle c2 = new Circle(q, radius2);

        assertNotEquals(c1.computeEuclideanDistanceToAnotherShape(c2), 10);
    }
}