import java.util.Scanner;

public class Order{
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
 class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].getTotalPrice() > orders[j+1].getTotalPrice()) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }
}
 class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi-1);  
            quickSort(orders, pi+1, high); 
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low-1); 
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;

        return i+1;
    }
}


 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter total price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        // Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("Bubble Sorted Orders: ");
        for (Order order : orders) {
            System.out.println(order);
        }
        //quick sort
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("Quick Sorted Orders: ");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}

        