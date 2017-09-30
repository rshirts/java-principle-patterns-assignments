package factories;

import products.*;

public class HRApplicationResFactory implements ApplicationResFactory {


    @Override
    public Drawing createDrawing() {
        return new HighResDrawing();
    }

    @Override
    public Printing createPrinting() {
        return new HighResPrinting();
    }
}
