import factories.ApplicationResFactory;
import products.Drawing;

public class RunningApplication extends Application {

    ApplicationResFactory resFactory;

    public RunningApplication(ApplicationResFactory resFactory) {
        this.resFactory = resFactory;
    }

    @Override
    public void prepare() {
        drawing = resFactory.createDrawing();
        printing = resFactory.createPrinting();
    }
}
