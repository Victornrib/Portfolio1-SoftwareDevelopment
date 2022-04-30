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
        assertEquals(points, poly.points);
    }


    @Test
    void testCreatePolygonError() {
        Point a = new Point(0,0);
        Point b = new Point(2,4);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b);

        Polygon poly = new Polygon(points);
        assertNotEquals(points, poly.points);
    }


    @Test
    void testCreatePolygonError2() {
        Point a = new Point(0,0);
        Point b = new Point(2,4);
        Point c = new Point(0,0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        assertNotEquals(points, poly.points);
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

    //WRONG
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

    //WRONG
    @Test
    void testComputeAreaPolygonError() {
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        Point c = new Point(0,2);
        Point d = new Point(2,2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c); points.add(d);

        Polygon poly = new Polygon(points);
        Double expectedArea = 16.0;

        assertEquals(expectedArea, poly.computeArea());
    }


    @Test
    void testComputeCircumferencePolygon() {
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        Point c = new Point(2,2);
        Point d = new Point(0,2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Double expectedCircumference = 8.885765876316732;

        assertEquals(expectedCircumference, poly.computeCircumference());
    }


    @Test
    void testComputeCircumferencePolygonError() {
        Point a = new Point(0,0);
        Point b = new Point(4,0);
        Point c = new Point(2,2);
        Point d = new Point(0,2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Double expectedCircumference = 8.885765876316732;

        assertNotEquals(expectedCircumference, poly.computeCircumference());
    }


    @Test
    void testCheckPointInside() {
        Point p = new Point(2,2);

        Point a = new Point(0,0);
        Point b = new Point(4,0);
        Point c = new Point(0,4);
        Point d = new Point(4,4);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Boolean expectedResult = true;

        assertEquals(expectedResult, poly.checkPointInside(p));
    }


    @Test
    void testCheckPointInsideError() {
        Point p = new Point(6,2);

        Point a = new Point(0,0);
        Point b = new Point(4,0);
        Point c = new Point(0,4);
        Point d = new Point(4,4);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c);

        Polygon poly = new Polygon(points);
        Boolean expectedResult = true;

        assertNotEquals(expectedResult, poly.checkPointInside(p));
    }


    @Test
    void testComputeEuclideanDistanceToShape() {
        Point a = new Point(1,1);
        Point b = new Point(-1,-1);
        Point c = new Point(1,-1);
        Point d = new Point(-1,1);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c); points.add(d);

        Point w = new Point(-2,2);
        Point x = new Point(2,2);
        Point y = new Point(-2,-2);
        Point z = new Point(2,-2);

        ArrayList<Point> points2 = new ArrayList<>();
        points2.add(a); points2.add(b); points2.add(c); points2.add(d);

        Polygon poly1 = new Polygon(points);
        Polygon poly2 = new Polygon(points2);
        Double expectedResult = 0.0;

        assertEquals(expectedResult, poly1.computeEuclideanDistanceToAnotherShape(poly2));
    }


    @Test
    void testComputeEuclideanDistanceToShapeError() {
        Point a = new Point(1,1);
        Point b = new Point(-1,-1);
        Point c = new Point(1,-1);
        Point d = new Point(-1,1);

        ArrayList<Point> points = new ArrayList<>();
        points.add(a); points.add(b); points.add(c); points.add(d);

        Point w = new Point(-2,2);
        Point x = new Point(2,2);
        Point y = new Point(-2,-2);
        Point z = new Point(2,-2);

        ArrayList<Point> points2 = new ArrayList<>();
        points2.add(a); points2.add(b); points2.add(c); points2.add(d);

        Polygon poly1 = new Polygon(points);
        Polygon poly2 = new Polygon(points2);
        Double expectedResult = 5.0;

        assertNotEquals(expectedResult, poly1.computeEuclideanDistanceToAnotherShape(poly2));
    }
}
