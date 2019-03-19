package org.automation.sandbox;

public class MyFirstProgram {

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
    public static void main(String[] args) {

        hello("world");
        hello("Dick");
        hello("Alexei");

        Square s = new Square(5);

        System.out.println("Ploschad' kvadrata so storonoy " + s.side + " = " + s.squareArea());

        Rectangle r = new Rectangle(4, 6);

        System.out.println("Ploschad' pramougla so storonami " + r.sidea + " and " + r.sideb + " = " + r.rectangleArea());

        Point a = new Point(3, 4);
        Point b = new Point(5, 6);
                
        System.out.println("Distance from the point with coordinates (" + a.axisx +" , " + a.axisy + ") to point with coordinates (" + b.axisx + "," + b.axisy + ") = " + a.distance(a, b));

        
    }
}