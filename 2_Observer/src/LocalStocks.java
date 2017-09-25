import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LocalStocks implements Observer {

    private ArrayList<TickerData> tickerDataArrayList;

    public LocalStocks () {
        tickerDataArrayList = new ArrayList<>();
    }

    @Override
    //public void update(SubjectData data) {
    public void update(ArrayList<TickerData> data) {
        tickerDataArrayList = data;
        process();
    }

    @Override
    public void process() {
        averageReport();
        change10Report();
        selectionsReport();
    }

    private void averageReport() {
        try {
            PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter(new FileWriter("Average.dat", true)));
            double averagePrice = 0;
            //add up the average price
            for (TickerData tick : tickerDataArrayList) {
                averagePrice += Double.parseDouble(tick.getCurrentPrice());
            }
            //find the average by dividing the total by the count.
            averagePrice /= tickerDataArrayList.size();
            bufferedWriter.println(tickerDataArrayList.get(0).getLastUpdateTimeStamp() + " " + averagePrice);
            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("There was an exception  with writing to Average.dat");
        }
    }

    private void change10Report() {
        try {
            PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter(new FileWriter("Change10.dat", true)));
            bufferedWriter.println();
            boolean count = false;

            //find all that changed price more than 10%
            for (TickerData tick : tickerDataArrayList) {
                if (count == false) {
                    bufferedWriter.println(tick.getLastUpdateTimeStamp());
                    count = true;
                }
                if (Math.abs(Double.parseDouble(tick.getPercentChange())) >= 10) {
                    bufferedWriter.println(tick.getTickerSymbol() + " " +
                            tick.getCurrentPrice() + " " + tick.getPercentChange());
                }
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("There was an exception with writing to Change10.dat");
        }
    }

    private void selectionsReport() {
        try {
            PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter(new FileWriter("Selections.dat", true)));
            bufferedWriter.println();
            bufferedWriter.println(tickerDataArrayList.get(0).getLastUpdateTimeStamp());

            //find all that changed price more than 10%
            for (TickerData tick : tickerDataArrayList) {
                if (tick.getTickerSymbol().equals("ALL")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("BA")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("BC")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("GBEL")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("KFT")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("MCD")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("TR")) {
                    bufferedWriter.println(tick.toString());
                } else if (tick.getTickerSymbol().equals("WAG")) {
                    bufferedWriter.println(tick.toString());
                }
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("There was an exception with writing to Selections.dat");
        }
    }
}
