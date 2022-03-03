package controller;

import model.Circle;
import model.Point;
import model.Polygon;
import model.Shape;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the drawing board!\n" +
                "Please choose if you would like to draw a Point, Polygon or Circle\n" +
                "(Type 'pt' for Point, 'poly' for Polygon or 'c' for circle): ");

        getDrawingType();
    }

    static void getDrawingType() {
        String str = sc.nextLine();

        if (str.equals("pt")) {
            Point p = drawPoint();
        }

        else if (str.equals("poly")) {
            System.out.println("Define how many points will your polygon have: ");
            int n = sc.nextInt();
            ArrayList<Point> points = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                points.add(drawPoint());
            }
            Polygon p = new Polygon(points);
        }

        else if (str.equals("c")) {
            System.out.println("Define the radius of the circle: ");
            int r = sc.nextInt();
            Point center = drawPoint();
            Circle c = new Circle(center, r);
        }

        else {
            System.out.println("You did not choose a valid type, please type again: ");
            getDrawingType();
        }
    }

    static Point drawPoint() {

        System.out.println("\nSelect the coordinate x of your point: ");
        int x = sc.nextInt();
        System.out.println("Select the coordinate y of your point: ");
        int y = sc.nextInt();
        return new Point(x,y);
    }
}