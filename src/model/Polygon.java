package model;

import java.util.ArrayList;

public class Polygon extends Shape {

    public Polygon(ArrayList<Point> points) {
        this.points = points;
        this.type = "poly";
        this.size = points.size();
        //this.size = ATUALIZAR DEPOIS DE DESCARTAR OS PONTOS IRRELEVANTES
    }
}
