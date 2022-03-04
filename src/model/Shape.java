package model;

import java.util.ArrayList;
import java.lang.Math;

public abstract class Shape {

    public String type;
    public ArrayList<Point> points;
    public Point center;
    public Integer radius;
    public Integer size;


    public Point returnCenter() {

        if (type.equals("poly")) {

            Point centroid = new Point(0,0);
            Integer signedArea = 0;
            for(int i = 0; i < this.size; i++) {

                Integer x0 = this.points.get(i).x;
                Integer y0 = this.points.get(i).y;
                Integer x1 = this.points.get( (i+1)%this.size ).x;
                Integer y1 = this.points.get( (i+1)%this.size ).y;

                Integer A = (x0 * y1) - (x1 * y0);
                signedArea += A;

                centroid.x += ( x0 + x1 ) * A;
                centroid.y += ( y0 + y1 ) * A;
            }
            signedArea = signedArea/2;
            centroid.x = ( centroid.x ) / ( 6 * signedArea);
            centroid.y = ( centroid.y ) / ( 6 * signedArea);

            return centroid;
        }
        else {
            return center;
        }
    }


    public Double computeArea() {

        Double area;
        if (type.equals("poly")) {
            area = 0.0;
        }
        else {
            area = Math.PI * Math.pow(radius,2);
        }
        return area; // FAZER
    }


    public Double computeCircumference() {

        Double circumference;
        if (type.equals("poly")) {
            circumference = 0.0;
        }
        else {
            circumference = 2 * Math.PI * radius;
        }
        return circumference;
    }


    public Boolean checkPointInside(Point p) {

        if (type.equals("poly")) {
            return false;
        }
        else {
            if (Math.sqrt( Math.pow(p.x-center.x,2) + Math.pow(p.y-center.y,2) ) < radius) {
                return true;
            }
            else {
                return false;
            }
        }
    }


    public Double computeEuclideanDistanceToAnotherShape(Shape s) {
        return  Math.sqrt( Math.pow(this.returnCenter().x - s.returnCenter().x, 2) + Math.pow(this.returnCenter().y - s.returnCenter().y, 2) );
    }
}
