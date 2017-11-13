package com.company;

public class Line extends Shape {
    @Override
    public void display() {
        System.out.println("Now Displaying a Line at " + location + " with color " + color);
    }

    @Override
    public void fill() {
        System.out.println("Line is now filled.");
    }

    @Override
    public void undisplay() {
        System.out.println("The Line at " + location + " with color " + color + " is now hidden.");
    }

}
