package ua.stqa.javka.sandbox;

public class MyFirstProgram {

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double area(double l) {
        return l * l;
    }

    public static double area(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {

        hello("world");
        hello("zaloopa");
        hello("Alexei");

        double l = 5;
        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

        double a = 4;
        double b = 6;

        System.out.println("Площадь прямоугла со сторонами " + a + " и " + b " = " + area(a, b));

        // System.out.println("Hello, "+ somebody);
        // String somebody = "world!";
        // double l = 8.0;
        // double s = 1 * 1;
        // System.out.println("Площадь квадрата со стороной " + 1 + " = " + s);
    }
}