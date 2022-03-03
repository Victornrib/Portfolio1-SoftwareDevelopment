package controller;

import model.Circle;
import model.Point;
import model.Polygon;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Program {


    public static void main(String[] args) {

        System.out.print("Welcome to the drawing board!\n");
        getDrawingType();
    }

    static void getDrawingType() {

        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nPlease choose if you would like to draw a point, polygon or circle\n" +
                "(Type 'pt' for Point, 'poly' for Polygon or 'c' for circle): ");

        String str = sc.nextLine();
        switch (str) {

            case "pt": {
                System.out.print("\n");
                Point pt = drawPoint();
                break;
            }

            case "poly": {
                System.out.print("\nDefine the length of the set of points that will create the polygon\n" +
                        "(ONLY CONVEX POLYGONS CAN BE CREATED - ALL POINTS THAT BECOME IRRELEVANT AFTER THE POLYGON CREATION WILL BE DISCARDED): ");
                int n = sc.nextInt();
                ArrayList<Point> points = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    System.out.println("\nPoint "+(i+1)+":");
                    points.add(drawPoint());
                }
                Polygon poly = new Polygon(points);
                break;
            }

            case "c":
                System.out.print("\nDefine the radius of the circle: ");
                int r = sc.nextInt();
                Point center = drawPoint();
                Circle c = new Circle(center, r);
                break;

            default:
                System.out.println("You did not choose a valid type.");
                getDrawingType();
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
                getDrawingType();
                break;

            case "n":
                System.out.println("\nOh right! See you next time :)");
                exit(0);
                break;

            default:
                System.out.println("\nSorry, I could not understand what you've meant...");
                repetitionChecker();
                break;
        }
    }


    static Point drawPoint() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Select the coordinate x of your point: ");
        int x = sc.nextInt();
        System.out.print("Select the coordinate y of your point: ");
        int y = sc.nextInt();
        return new Point(x,y);
    }
}