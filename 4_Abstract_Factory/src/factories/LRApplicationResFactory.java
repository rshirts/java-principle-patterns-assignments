package factories;

import products.Drawing;
import products.LowResDrawing;
import products.LowResPrinting;
import products.Printing;

public class LRApplicationResFactory implements ApplicationResFactory {
    @Override
    public Drawing createDrawing() {
        return new LowResDrawing();
    }

    @Override
    public Printing createPrinting() {
        return new LowResPrinting();
    }
}
