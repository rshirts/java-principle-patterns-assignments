import java.io.Writer;

class LineOutput extends Decorator {

    public LineOutput(Output op) {output = op;}

    @Override
    public void write(Object o) {
        output.write(o);
    }

    @Override
    public void writeString(String s) {
        output.writeString(s + "\n");
    }
}
