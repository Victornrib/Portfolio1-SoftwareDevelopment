package controller;

import model.Circle;
import model.Point;
import model.Polygon;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;


public class Program {


    public static void main(String[] args) {

        System.out.print("Welcome to the drawing board!\n");
        draw();
    }


    static void draw() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nPlease choose if you would like to draw a point, polygon or circle\n" +
                "(Type 'pt' for Point, 'poly' for Polygon or 'c' for circle): ");

        String str = sc.nextLine();
        switch (str) {

            case "pt": {
                System.out.print("\n");
                Point pt = generatePoint();
                break;
            }
            case "poly": {
                Polygon poly = generatePolygon();
                break;
            }

            case "c":
                Circle c = generateCircle();
                break;

            default:
                System.out.println("You did not choose a valid type.");
                draw();
                break;
        }
        System.out.println("\nAwesome!");
        repetitionChecker();
    }


    static void repetitionChecker() {

        System.out.print("Would you like to draw one more point, polygon or circle?\n" +
        "(Press 'y' to yes or 'n' to no): ");

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        switch (str) {

            case "y":
                draw();
                break;

            case "n":
                System.out.println("\nOh right! See you next time :)");
                exit(0);
                break;

            default:
                System.out.println("Sorry, I could not understand what you've meant...\n");
                repetitionChecker();
                break;
        }
    }


    static Circle generateCircle() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDefine the radius of the circle: ");
        String str = sc.nextLine();
        try {
            int r = Integer.parseInt(str);
            Point center = generatePoint();
            return new Circle(center, r);
        }
        catch (NumberFormatException e) {
            System.out.println("Please input a valid number.");
            return generateCircle();
        }
    }


    static Polygon generatePolygon() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDefine the number of vertices of the polygon (Must be 3 or more)\n" +
                "(ONLY CONVEX POLYGONS CAN BE CREATED - ALL POINTS THAT BECOME IRRELEVANT AFTER THE POLYGON CREATION WILL BE DISCARDED): ");

        String str = sc.nextLine();
        try {
            int n = Integer.parseInt(str);
            ArrayList<Point> points = new ArrayList<>();
            if (n >= 3) {

                System.out.println("\nPoint 1:");
                points.add(generatePoint());

                for (int i = 1; i < n; i++) {
                    System.out.println("\nPoint " + (i + 1) + ":");
                    Point nextPoint = generatePoint();

                    for (Point point : points) {

                        if (Objects.equals(point.x, nextPoint.x) && Objects.equals(point.y, nextPoint.y)) {
                            System.out.println("Two vertices of the polygon can't be the same, please do it again.\n");
                            return generatePolygon();
                        }
                    }
                    points.add(nextPoint);
                }
                return new Polygon(points);
            } else {
                System.out.println("You have entered a invalid number of vertices, please enter a valid number.\n");
                return generatePolygon();
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Please input a valid number.\n");
            return generatePolygon();
        }
    }


    static Point generatePoint() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Select the coordinate x of your point: ");
        String str = sc.nextLine();
        try {
            int x = Integer.parseInt(str);
            System.out.print("Select the coordinate y of your point: ");
            str = sc.nextLine();
            int y = Integer.parseInt(str);
            return new Point(x,y);
        }
        catch (NumberFormatException e) {
            System.out.println("Please input a valid number.\n");
            return generatePoint();
        }
    }
}