package model;

import java.util.ArrayList;

public class Polygon extends Shape {
    public ArrayList<Point> Points;

    public Polygon(ArrayList<Point> Points) {
        this.Points = Points;
    }
}
