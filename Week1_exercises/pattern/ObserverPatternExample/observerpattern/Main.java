// Main.java
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("Sansax");

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(56.89);
        stockMarket.setStockPrice(948.43);
        stockMarket.setStockPrice(160.50);
    }
}
