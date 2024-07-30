// Main.java
public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("5656785678654234", "Salman Khan", "123", "12/23");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(579.00);

        PaymentStrategy payPalPayment = new PayPalPayment("sallubhai@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(578.00);
    }
}
