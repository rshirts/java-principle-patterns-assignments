import products.*;

public abstract class Application {

    protected Drawing drawing;
    protected Printing printing;

    public abstract void prepare();

    public void display() {
        drawing.display();
        printing.display();
    }




}
