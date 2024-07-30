// WebApp.java
public class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App Notification: " + stockName + " stock price is now $" + stockPrice);
    }
}