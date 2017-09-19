public class TickerData{

    private String company;
    private String tickerSymbol;
    private String currentPrice;
    private String dollarChange;
    private String percentChange;
    private String percentChangeYTD;
    private String highFiftyTwoWeek;
    private String lowFiftyTwoWeek;
    private String ratioPE;
    private String lastUpdateTimeStamp;

    @Override
    public String toString() {
        String returnString = (company + " " + tickerSymbol + " " + currentPrice + " " + dollarChange
        + " " + percentChange + " " + percentChangeYTD + " " + percentChangeYTD + " " + highFiftyTwoWeek
        + " " + lowFiftyTwoWeek + " " + ratioPE);
        return returnString;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDollarChange() {
        return dollarChange;
    }

    public void setDollarChange(String dollarChange) {
        this.dollarChange = dollarChange;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getPercentChangeYTD() {
        return percentChangeYTD;
    }

    public void setPercentChangeYTD(String percentChangeYTD) {
        this.percentChangeYTD = percentChangeYTD;
    }

    public String getHighFiftyTwoWeek() {
        return highFiftyTwoWeek;
    }

    public void setHighFiftyTwoWeek(String highFiftyTwoWeek) {
        this.highFiftyTwoWeek = highFiftyTwoWeek;
    }

    public String getLowFiftyTwoWeek() {
        return lowFiftyTwoWeek;
    }

    public void setLowFiftyTwoWeek(String lowFiftyTwoWeek) {
        this.lowFiftyTwoWeek = lowFiftyTwoWeek;
    }

    public String getRatioPE() {
        return ratioPE;
    }

    public void setRatioPE(String ratioPE) {
        this.ratioPE = ratioPE;
    }

    public String getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(String lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }


}
