// TestLogger.java
public class TestLogger {
    public static void main(String[] args) {
        // Get the instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Singleton instance confirmed!");
        } else {
            System.out.println("Different instances detected!");
        }

        // Test logging
        logger1.log("This is a test log message.");
        logger2.log("This is another log message.");
    }
}
