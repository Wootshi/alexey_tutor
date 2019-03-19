package org.automation.sandbox;

public class Rectangle {

    public double sidea;
    public double sideb;

    public Rectangle(double sidea, double sideb) {
        this.sidea = sidea;
        this.sideb = sideb;
    }

    public double rectangleArea() {
        return this.sidea * this.sideb;

    }
}