// Logger.java
public class Logger {
    // Step 2.1: Create a private static instance of Logger
    private static Logger instance;

    // Step 2.2: Make the constructor private
    private Logger() {
        // Initialize resources if needed
    }

    // Step 2.3: Provide a public static method to get the instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
