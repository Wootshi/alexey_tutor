package org.automation.sandbox;

public class MyFirstProgram {

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
    public static void main(String[] args) {

        hello("world");
        hello("zaloopa");
        hello("Alexei");

        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.side + " = " + s.squareArea());

        Rectangle r = new Rectangle(4, 6);

        System.out.println("Площадь прямоугла со сторонами " + r.sidea + " и " + r.sideb + " = " + r.rectangleArea());

        // System.out.println("Hello, "+ somebody);
        // String somebody = "world!";
        // double l = 8.0;
        // double s = 1 * 1;
        // System.out.println("Площадь квадрата со стороной " + 1 + " = " + s);
    }
}