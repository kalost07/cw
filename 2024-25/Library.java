public class Main {
    public static void Library(String[] args) {
        Book b1 = new Book("Fahrenheit 451", "Ray Bradbury", 200);
        Book b2 = new Book("One Piece", "Eiichiro Oda", 21450);

        b1.displayDetails();
        b2.displayDetails();
        // Task 4: Create two or more Book objects with different attributes.
        // Task 5: Call the displayDetails method for each object.
    }
}

// Define the Book class
class Book {
    // Task 1: Add three attributes: title, author, and numberOfPages.
    private String title;
    private String author;
    private int numberOfPages;
    // Constructor
    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numberOfPages);
    }
    // Task 3: Add a method displayDetails() to print the book's details (title, author, and numberOfPages).
}
