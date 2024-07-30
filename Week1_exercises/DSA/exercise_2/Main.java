import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of products from user
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Create array of products
        Product[] products = new Product[numProducts];

        // Get product details from user
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String productName = scanner.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        // Get target product ID from user for search
        System.out.print("Enter product ID to search: ");
        int targetId = scanner.nextInt();

        // Linear Search
        Product resultLinear = SearchUtils.linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + resultLinear);

        // Sort products by productId for Binary Search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Binary Search
        Product resultBinary = SearchUtils.binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + resultBinary);

        scanner.close();
    }
}
public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{productId=" + productId + ", productName='" + productName + "', category='" + category + "'}";
    }
}

public class SearchUtils {

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductId() == targetId) {
                return midProduct;
            } else if (midProduct.getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
