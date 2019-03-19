package org.automation.java;

public class Point {

    public double axisx;
    public double axisy;
    
    public Point(double axisx, double axisy) {
        this.axisx = axisx;
        this.axisy = axisy;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt((p2.axisx - p1.axisx)*(p2.axisx - p1.axisx) + (p2.axisy - p1.axisy)*(p2.axisy - p1.axisy));
        
    }
}