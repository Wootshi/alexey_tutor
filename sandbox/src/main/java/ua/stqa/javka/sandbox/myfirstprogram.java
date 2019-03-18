package ua.stqa.javka.sandbox;

public class MyFirstProgram {

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double squarearea(Square s) {
        return s.side * s.side;
    }

    public static double rectanglearea(Rectangle r) {
        return r.sidea * r.sideb;
    }

    public static void main(String[] args) {

        hello("world");
        hello("zaloopa");
        hello("Alexei");

        Square square1 = new Square();
        square1.side = 5;
                
        System.out.println("Площадь квадрата со стороной " + square1.side + " = " + squarearea(square1));

        Rectangle rectangle1 = new Rectangle();
        rectangle1.sidea = 4;
        rectangle1.sideb = 6;        

        System.out.println("Площадь прямоугла со сторонами " + rectangle1.sidea + " и " + rectangle1.sideb + " = " + rectanglearea(rectangle1));

        // System.out.println("Hello, "+ somebody);
        // String somebody = "world!";
        // double l = 8.0;
        // double s = 1 * 1;
        // System.out.println("Площадь квадрата со стороной " + 1 + " = " + s);
    }
}