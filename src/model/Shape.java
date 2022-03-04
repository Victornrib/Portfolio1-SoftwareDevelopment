package model;

import java.util.ArrayList;
import java.lang.Math;

public abstract class Shape {

    public String type;
    public ArrayList<Point> points;
    public Integer size;
    public Point center;
    public Integer radius;


    public Point returnCenter() {

        // RETURNS ROUNDED APPROXIMATION FOR FITTING IN POINT
        if (type.equals("poly")) {

            Point centroid = new Point(0,0);
            double AuxCentroidX = 0.0;
            double AuxCentroidY = 0.0;

            double signedArea = 0.0;
            for(int i = 0; i < this.size; i++) {

                Double x0 = (double) this.points.get(i).x;
                Double y0 = (double) this.points.get(i).y;
                Double x1 = (double) this.points.get( (i+1)%this.size ).x;
                Double y1 = (double) this.points.get( (i+1)%this.size ).y;

                double A = (x0 * y1) - (x1 * y0);
                signedArea += A;

                AuxCentroidX += ( x0 + x1 ) * A;
                AuxCentroidY += ( y0 + y1 ) * A;
            }
            signedArea = signedArea/2;
            AuxCentroidX = ( AuxCentroidX ) / ( 6 * signedArea);
            AuxCentroidY = ( AuxCentroidY ) / ( 6 * signedArea);

            centroid.x = (int) Math.round(AuxCentroidX);
            centroid.y = (int) Math.round(AuxCentroidY);

            return centroid;
        }
        else {
            return center;
        }
    }


    public Double computeArea() {

        double area = 0.0;
        if (type.equals("poly")) {

            for(int i = 0; i < this.size; i++) {

                if (i == 0)
                {
                    System.out.println(this.points.get(i).x + "x" + (this.points.get(i + 1).y + "-" + this.points.get(this.points.size() - 1).y));
                    area += this.points.get(i).x * (this.points.get(i + 1).y - this.points.get(this.points.size() - 1).y);
                }
                else if (i == this.points.size() - 1)
                {
                    System.out.println(this.points.get(i).x + "x" + (this.points.get(0).y + "-" + this.points.get(i - 1).y));
                    area += this.points.get(i).x * (this.points.get(0).y - this.points.get(i - 1).y);
                }
                else
                {
                    System.out.println(this.points.get(i).x + "x" + (this.points.get(i + 1).y + "-" + this.points.get(i - 1).y));
                    area += this.points.get(i).x * (this.points.get(i + 1).y - this.points.get(i - 1).y);
                }
            }
            area = Math.abs(area)/2;
        }
        else {
            area = Math.PI * Math.pow(radius,2);
        }
        return area;
    }


    public Double computeCircumference() {

        double circumference;
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
