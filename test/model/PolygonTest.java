package model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class PolygonTest {

    @Test
    void testCreatePolygon() {
        Point a = new Point(0,0);
        Point b = new Point(2,4);
        Point c = new Point(4,0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        assertEquals(poly.type,"poly");
    }


    @Test
    void testCreatePolygonError() {
        Point a = new Point(0,0);
        Point b = new Point(2,4);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b);

        Polygon poly = new Polygon(points);
        assertNotEquals(poly.type,"poly");
    }


    @Test
    void testReturnCenterPolygon() {

        Point a = new Point(0,0);
        Point b = new Point(2,4);
        Point c = new Point(4,0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Point expectedCentroid = new Point(2,1);

        assertEquals(expectedCentroid.x, poly.returnCenter().x);
        assertEquals(expectedCentroid.y, poly.returnCenter().y);
    }


    @Test
    void testReturnCenterPolygonError() {

        Point a = new Point(0,0);
        Point b = new Point(2,4);
        Point c = new Point(8,0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Point expectedCentroid = new Point(4,7);

        assertNotEquals(expectedCentroid.x, poly.returnCenter().x);
        assertNotEquals(expectedCentroid.y, poly.returnCenter().y);
    }


    @Test
    void testComputeAreaPolygon() {

        Point a = new Point(0,0);
        Point b = new Point(2,0);
        Point c = new Point(0,2);
        Point d = new Point(2,2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c); points.add(d);

        Polygon poly = new Polygon(points);
        Double expectedArea = 4.0;

        assertEquals(expectedArea, poly.computeArea());
    }
}