package model;

import java.util.ArrayList;

public class Polygon extends Shape {
    public ArrayList<Point> Points;

    Polygon(ArrayList<Point> Points) {
        this.Points = Points;
    }
}
