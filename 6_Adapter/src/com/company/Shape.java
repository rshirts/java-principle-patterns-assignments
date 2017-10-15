package com.company;

public abstract class Shape {

    String location = "0,0";
    String color = "Blue";

    public abstract void display();
    public abstract void fill();
    public abstract void undisplay();

    public void setLocation(String location){
        System.out.println("Changing location from " + this.location + " to " + location);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setColor(String color) {
        System.out.println("Changing color from " + this.color + " to " + color);
        this.color = color;
    }
}
