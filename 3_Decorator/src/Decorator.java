public abstract class Decorator implements Output {

    protected Output output;

    @Override
    public abstract void write(Object o);

    @Override
    public abstract void writeString(String s);
}
