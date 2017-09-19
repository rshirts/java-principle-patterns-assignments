import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Ticker ticker = new Ticker();
        TickerData tickerData = null;
        LocalStocks localStocks = new LocalStocks();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        // Add observer to Subject (localStocks to Ticker)
        ticker.registerObserver(localStocks);

        //Processing static filename for this assignment.
        try {
            fileReader = new FileReader("Ticker.dat");
            bufferedReader = new BufferedReader(fileReader);

            String currentLine;
            String[] words;
            String lastUpdate = "";

            //file open parse data.
            while((currentLine = bufferedReader.readLine()) != null) {
                if (!currentLine.isEmpty()) {
                    tickerData = new TickerData();
                    words = currentLine.split("\\s+");
                    if (words[0].equals("Last")) {
                        lastUpdate = currentLine;
                    } else {
                        int index = words.length - 1;
                        //not end of object and not a new object timestamp populate data.
                        tickerData.setLastUpdateTimeStamp(lastUpdate);
                        tickerData.setRatioPE(words[index--]);
                        tickerData.setLowFiftyTwoWeek(words[index--]);
                        tickerData.setHighFiftyTwoWeek(words[index--]);
                        tickerData.setPercentChangeYTD(words[index--]);
                        tickerData.setPercentChange(words[index--]);
                        tickerData.setDollarChange(words[index--]);
                        tickerData.setCurrentPrice(words[index--]);
                        tickerData.setTickerSymbol(words[index--]);

                        //compose company name from remaining items in array.
                        String companyName = "";
                        for (int i = 0; i <= index ; i++) {
                            companyName += words[i];
                            if (i < index) {
                                companyName += " ";
                            }
                        }
                        tickerData.setCompany(companyName);

                        //ticker data updated send to subject so it can send to observers.
                        ticker.setTickerData(tickerData);
                    }
                } else {
                    ticker.setTickerData(null);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open file " + e);
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished processing all updates.");
    }
}
