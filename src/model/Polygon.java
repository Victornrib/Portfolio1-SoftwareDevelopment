package model;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon extends Shape {

    public Integer size;
    public ArrayList<Point> points;

    //Receives an ArrayList of Points related to the vertices
    public Polygon(ArrayList<Point> points) {

        //Checks if the polygon has 3 or more than 3 vertices
        if (points.size() >= 3) {

            //Checks if none of the polygon vertices are equal
            for (int i = 0; i < points.size(); i++) {
                for (int j = 0; j < points.size(); j++) {
                    if ( (i != j) && (Objects.equals(points.get(i).x, points.get(j).x) && Objects.equals(points.get(i).y, points.get(j).y)) ) {
                        return;
                    }
                }
            }

            //If everything is ok, it generates its internal fields
            this.points = points;
            this.size = points.size();
        }
    }

    //Calculates the center of o polygon based on the coordinates of its vertices
    @Override
    public Point returnCenter() {

        center = new Point(0,0);
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

        center.x = (int) Math.round(AuxCentroidX);
        center.y = (int) Math.round(AuxCentroidY);

        return center;
    }


    //Computes and returns the area of a polygon based on the coordinates of its vertices
    @Override
    public Double computeArea() {

        area = 0.0;
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
        return area;
    }


    //Computes and returns the circumference of a polygon based on the coordinates of its vertices
    @Override
    public Double computeCircumference() {

        center = this.returnCenter();
        double radius = 0.0;
        double distance;

        for (int i = 0; i < this.size; i++) {
            distance = Math.sqrt( Math.pow(points.get(i).x-center.x,2) + Math.pow(points.get(i).y-center.y,2) );
            if (distance > radius) {
                radius = distance;
            }
        }
        circumference = 2 * Math.PI * radius;
        return circumference;
    }


    //Checks if there is a point inside a polygon based on the coordinates of its vertices
    @Override
    public Boolean checkPointInside(Point p) {
        return false;
    }
}
