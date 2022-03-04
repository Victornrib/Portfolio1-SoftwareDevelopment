package model;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon extends Shape {

    public Polygon(ArrayList<Point> points) {

        if (points.size() >= 3) {

            for (int i = 0; i < points.size(); i++) {
                for (int j = 0; j < points.size(); j++) {
                    if ( (i != j) && (Objects.equals(points.get(i).x, points.get(j).x) && Objects.equals(points.get(i).y, points.get(j).y)) ) {
                        return;
                    }
                }
            }

            this.points = points;
            this.type = "poly";
            this.size = points.size();
            //this.size = ATUALIZAR DEPOIS DE DESCARTAR OS PONTOS IRRELEVANTES
        }
    }
}
