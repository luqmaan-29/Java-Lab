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
        if (isAvailable) 
        {
            isAvailable = false;
              System.out.println("Book borrowed: " + title);
        } else
         {
                 System.out.println("Book is unavailable: " + title);
        }
    }
    public void returnBook() 
    {
    if (!isAvailable) 
    {
     isAvailable = true;
                System.out.println("Book returned: " + title);
        }   
        else 
        {
                           System.out.println("Book was not borrowed: " + title);
        }
    }
    public void displayInfo() 
    {
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
public class LibraryManagementSystem {
    public static void main(String[] args) 
    {
           Book book1 = new FictionBook(101, "ghost diaries", "alan john", "horror");
       Book book2 = new ReferenceBook(201, "design of algorithms", "syed ali", 3);
   Book book3 = new FictionBook(102,"horror comedies","vivek george","horror");

        
System.out.println("Library Inventory:");
    book1.displayInfo();
       book2.displayInfo();
       book3.displayInfo();

        
System.out.println("\nBorrowing Books:");
   book2.borrowBook(); 
     book2.borrowBook(); 

System.out.println("\nReturning Books:");
         book2.returnBook(); 


        System.out.println("\nLibrary Final Stats:");
                book1.displayInfo();
                    book2.displayInfo();
    }
}
