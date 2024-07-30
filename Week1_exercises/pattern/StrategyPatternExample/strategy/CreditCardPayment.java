// CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String name, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card: " + cardNumber);
    }
}
