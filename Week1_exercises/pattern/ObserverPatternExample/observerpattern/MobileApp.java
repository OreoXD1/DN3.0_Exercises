// MobileApp.java
public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App Notification: " + stockName + " stock price is now $" + stockPrice);
    }
}
