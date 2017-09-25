class NumberedOutput extends Decorator {

    private int lineNumber = 1;

    public NumberedOutput(Output op) {output = op;}

    @Override
    public void write(Object o) {
        output.write(o);
    }

    @Override
    public void writeString(String s) {
        //Add lineNumber and incrament.
        String formatedLineNumber = String.format("%5s: ",lineNumber++ );
        output.writeString(formatedLineNumber + s);
    }
}
