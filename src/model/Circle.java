package model;

public class Circle extends Shape {

    public Integer radius;

    //Creates a circle based on a given center and radius
    public Circle(Point center, Integer radius) {
        this.center = center;
        this.radius = radius;
    }

    //Returns the center of the circle
    @Override
    public Point returnCenter() {
        return center;
    }

    //Computes and returns the area of the circle based on circle area formula
    @Override
    public Double computeArea() {
        area = Math.PI * Math.pow(radius,2);
        return area;
    }

    //Computes and returns the circumference of the circle
    @Override
    public Double computeCircumference() {
        circumference = 2 * Math.PI * radius;
        return circumference;
    }

    //Checks if a point is inside the circle
    public Boolean checkPointInside(Point p) {
        return Math.sqrt(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2)) < radius;
    }
}
