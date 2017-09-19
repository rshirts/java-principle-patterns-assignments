import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<TickerData> data);
    public void process();
}
