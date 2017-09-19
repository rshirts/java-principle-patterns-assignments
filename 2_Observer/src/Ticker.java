import java.util.ArrayList;

public class Ticker implements Subject {

    private ArrayList<Observer> obsserverList;
    private TickerData tickerData;
    private ArrayList<TickerData> tickerDataArray;

    public Ticker() {
        obsserverList = new ArrayList<>();
        tickerDataArray = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        obsserverList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        obsserverList.remove(o);
    }

    @Override
    public void notifyObserver() {
        if (tickerDataArray != null && tickerDataArray.size() > 0) {
            for(Observer o : obsserverList) {
                o.update(tickerDataArray);
            }
            System.out.println("Notified Observers of new data...");
        }
    }

    // When the tidkerData is updated it notifies the observers.
    public void setTickerData(TickerData tickerData) {
        if (tickerData == null) {
            notifyObserver();
        } else {
            tickerDataArray.add(tickerData);
        }
    }
}
