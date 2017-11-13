package com.company;

public class XXCirlceAdapter extends Shape {

    XXCircle xxCircle;

    public  XXCirlceAdapter(XXCircle xxCircle) {
        this.xxCircle = xxCircle;
    }

    @Override
    public void setLocation(String location) {
        xxCircle.setLocation(location);
    }

    @Override
    public String getLocation() {
        return xxCircle.getLocation();
    }

    @Override
    public void setColor(String color) {
        xxCircle.setItsColor(color);
    }

    @Override
    public void display() {
        xxCircle.displayIt();
    }

    @Override
    public void fill() {
        xxCircle.fillIt();
    }

    @Override
    public void undisplay() {
        xxCircle.undisplayIt();
    }
}
