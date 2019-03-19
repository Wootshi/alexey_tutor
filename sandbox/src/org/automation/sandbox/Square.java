package org.automation.sandbox;

public class Square {
    public double side;

    public Square(double side) {
        this.side = side;
    }

    public double squareArea() {
        return this.side * this.side;
    }

}
