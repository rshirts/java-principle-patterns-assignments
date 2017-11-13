package com.company;

public class Rectangle extends Shape {
    @Override
    public void display() {
        System.out.println("Now Displaying a Rectangle at " + location + " with color " + color);
    }

    @Override
    public void fill() {
        System.out.println("Rectangle is now filled.");
    }

    @Override
    public void undisplay() {
        System.out.println("The Rectangle at " + location + " with color " + color + " is now hidden.");
    }
}
