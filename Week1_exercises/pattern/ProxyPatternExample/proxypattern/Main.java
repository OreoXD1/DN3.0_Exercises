// Main.java
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image is not loaded yet
        image1.display();
        System.out.println("Image1 displayed");

        // Image is loaded and displayed
        image1.display();
        System.out.println("Image1 displayed again");

        // Image is not loaded yet
        image2.display();
        System.out.println("Image2 displayed");

        // Image is loaded and displayed
        image2.display();
        System.out.println("Image2 displayed again");
    }
}