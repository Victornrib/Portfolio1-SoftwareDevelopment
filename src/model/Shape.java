package model;

import java.lang.Math;
import java.util.ArrayList;

public abstract class Shape {

    public Point center;
    public Double area;
    public Double circumference;

    public abstract Point returnCenter();

    public abstract Double computeArea();

    public abstract Double computeCircumference();

    public abstract Boolean checkPointInside(Point p);

    public Double computeEuclideanDistanceToAnotherShape(Shape s) {
        return  Math.sqrt( Math.pow(this.returnCenter().x - s.returnCenter().x, 2) + Math.pow(this.returnCenter().y - s.returnCenter().y, 2) );
    }
}
