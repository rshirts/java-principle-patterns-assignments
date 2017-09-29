class FilterOutput extends Decorator {

    Output outputTwo = null;
    Predicate predicate = null;

    public FilterOutput(Output op, Predicate p) {
        output = op;
        predicate = p;
    }

    @Override
    public void write(Object o) {
        output.write(o);
    }

    @Override
    public void writeString(String s) {
        if (predicate.testCondition(s)) {
            output.writeString(s);
        }
    }
}
