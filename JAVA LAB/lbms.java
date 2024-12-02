import java.util.Scanner;

// Base Class
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(int bookId, String title, String author) {
        if (bookId <= 0) {
            System.out.println("Book ID must be positive.");
        }
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book is unavailable: " + title);
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not borrowed: " + title);
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Derived Class
class ReferenceBook extends Book {
    private int edition;

    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Edition: " + edition);
    }
}

// Derived Class
class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}

// Main Class
public class lbms{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter details for 3 books:");

        // Create an array to store books
        Book[] books = new Book[3];

        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter book type (1 for Fiction, 2 for Reference): ");
            int bookType = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("Enter book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            if (bookType == 1) {
                System.out.print("Enter genre for Fiction book: ");
                String genre = scanner.nextLine();
                books[i] = new FictionBook(bookId, title, author, genre);
            } else if (bookType == 2) {
                System.out.print("Enter edition for Reference book: ");
                int edition = scanner.nextInt();
                books[i] = new ReferenceBook(bookId, title, author, edition);
            } else {
                System.out.println("Invalid book type. Please enter 1 for Fiction or 2 for Reference.");
                i--; // Re-enter the current book's details
            }
        }

        // Display the library inventory
        System.out.println("\nLibrary Inventory:");
        for (Book book : books) {
            book.displayInfo();
        }

        // Borrow and return books
        System.out.println("\nBorrowing Books:");
        books[1].borrowBook();  // Borrow the second book (example)
        books[1].borrowBook();  // Try borrowing again

        System.out.println("\nReturning Books:");
        books[1].returnBook();  // Return the second book

        // Display the final library stats
        System.out.println("\nLibrary Final Stats:");
        for (Book book : books) {
            book.displayInfo();
        }

        scanner.close();
    }
}

