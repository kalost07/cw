import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Book[] bookArray = {
                new Book("Project Hail Mary", "Andy Weir", 2021),
                new Book("Dune", "Frank Herbert", 1965),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Moby-Dick", "Herman Melville", 1851)
        };
        int choice = 0;
        do{
            System.out.print("""
                    1. Display library
                    2. Search library by title
                    3. Borrow book
                    4. Return book
                    0. Exit
                    """);
            System.out.print("Enter the option: ");
            choice = read.nextInt();
            switch(choice) {
                case 1:
                    displayLibrary(bookArray);
                    break;
                case 2:
                    System.out.print("Enter title to search for: ");
                    read.nextLine();
                    int index = findBookByTitle(bookArray, read.nextLine());
                    if(index == -1) System.out.println("Book not found");
                    else System.out.println(bookArray[index].getDetails());
                    break;
                case 3:
                    borrowBook(bookArray, read);
                    break;
                case 4:
                    System.out.print("Enter title to search for: ");
                    read.nextLine();
                    if(returnBook(bookArray, read.nextLine()))
                        System.out.println("Book returned");
                    else System.out.println("Book not found");
                    break;
                case 0:
                    return;
            }
        } while(true);
    }
    public static void displayLibrary(Book[] books) {
        for(int i = 0; i < books.length; i++) {
            System.out.println("Book " + i + ": " + books[i].getDetails());
        }
    }

    public static void borrowBook(Book[] books, Scanner scanner) {
        int num;
        do{
            System.out.print("Enter valid book number: ");
            num = scanner.nextInt();
        } while(!(num >= 0 && num < books.length && books[num].getBorrowerName() == null));
        System.out.print("Enter borrower name: ");
        scanner.nextLine();
        books[num].borrowBook(scanner.nextLine());
    }

    public static int findBookByTitle(Book[] books, String title) {
        for(int i = 0; i < books.length; i++) {
            if(books[i].getTitle().equals(title)) return i;
        }
        return -1;
    }

    public static boolean returnBook (Book[] books, String title) {
        int index = findBookByTitle(books, title);
        if(index == -1) return false;
        books[index].returnBook();
        return true;
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName = null;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getDetails() {
        String res = String.format("%s - %s (%d)", title, author, yearPublished);
        if(borrowerName != null) res += (", borrowed by " + borrowerName);
        return res;
    }

    public void updateBookInfo(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void borrowBook(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void returnBook() {
        borrowerName = null;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getTitle() {
        return title;
    }
}
