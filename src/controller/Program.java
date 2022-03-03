package controller;

import model.Point;
import model.Shape;

public class Program {
    public Program() {
    }

    public static void main(String[] args) {
        Shape s = new Shape();
        Point p = s.returnCenter();
        System.out.println(p.x);
        System.out.println(p.y);
    }
}