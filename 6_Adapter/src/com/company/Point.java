package com.company;

public class Point extends Shape {
    @Override
    public void display() {
        System.out.println("Now Displaying a Point at " + location + " with color " + color);
    }

    @Override
    public void fill() {
        System.out.println("Point is now filled.");
    }

    @Override
    public void undisplay() {
        System.out.println("The Point at " + location + " with color " + color + " is now hidden.");
    }
}
