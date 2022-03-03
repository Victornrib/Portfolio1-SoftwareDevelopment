package model;

import java.util.ArrayList;

public class Polygon extends Shape {
    public ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
        //this.size = FAZER DEPOIS DE DESCARTAR OS PONTOS IRRELEVANTES
    }
}
