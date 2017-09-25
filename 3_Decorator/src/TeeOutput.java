class TeeOutput extends Decorator {

    private int lineNumber = 1;
    Output outputTwo = null;

    public TeeOutput(Output op, Output opTwo) {
        output = op;
        outputTwo = opTwo;
    }

    @Override
    public void write(Object o) {
        output.write(o);
    }

    @Override
    public void writeString(String s) {
        output.writeString(s);
        outputTwo.writeString(s);
    }
}
