package com.company;

public class Main {

    public static void main(String[] args) {
        Line line = new Line();
        Point point = new Point();
        Rectangle rectangle = new Rectangle();
        XXCircle xxCircle = new XXCircle();
        XXCirlceAdapter xxCirlceAdapter = new XXCirlceAdapter(xxCircle);

        line.display();
        point.display();
        rectangle.display();
        //call all of XXCircles adapted methods with the adapter calls.
        xxCirlceAdapter.display();
        xxCirlceAdapter.setColor("Yellow");
        xxCirlceAdapter.setLocation("10,10");
        xxCirlceAdapter.undisplay();
        xxCirlceAdapter.display();
    }
}
