package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

public class XXCircle {

    String location = "5,5";
    String color = "Green";

    public void setLocation(String location) {
        System.out.println("Changing location from " + this.location + " to " + location);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setItsColor(String color) {
        System.out.println("Changing color from " + this.color + " to " + color);
        this.color = color;
    }

    public void undisplayIt() {
        System.out.println("The XXCircle at " + location + " with color " + color + " is now hidden.");
    }

    public void displayIt() {
        System.out.println("Now Displaying an XXCirle at " + location + " with color " + color);
    }

    public void fillIt() {
        System.out.println("XXCircle is now filled.");
    }
}
