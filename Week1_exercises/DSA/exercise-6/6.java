import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    // Linear search function
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search function (requires sorted list by title)
    public static Book binarySearch(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Choose an action: ");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Adding a book
                    System.out.println("Enter book ID:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();

                    books.add(new Book(bookId, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // Searching for a book
                    System.out.println("Enter search type (linear/binary):");
                    String searchType = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Enter book title to search:");
                    String searchTitle = scanner.nextLine().trim();

                    if (searchType.equals("linear")) {
                        // Linear search
                        Book result = linearSearch(books, searchTitle);
                        System.out.println("Linear Search Result:");
                        if (result != null) {
                            System.out.println(result);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else if (searchType.equals("binary")) {
                        // Binary search (sort the list first)
                        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

                        Book result = binarySearch(books, searchTitle);
                        System.out.println("Binary Search Result:");
                        if (result != null) {
                            System.out.println(result);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Invalid search type. Please enter 'linear' or 'binary'.");
                    }
                    break;

                case 3:
                    continueRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        scanner.close();
    }
}
