import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author);
    }
}

public class LibraryManagementSystem {

    // Linear Search
    static Book linearSearch(Book[] books, String key) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(key)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    static Book binarySearch(Book[] books, String key) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = books[mid].title.compareToIgnoreCase(key);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C Programming", "Dennis Ritchie"),
                new Book(104, "Data Structures", "Mark Allen Weiss"),
                new Book(105, "Operating Systems", "Abraham Silberschatz")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book book1 = linearSearch(books, "Python");

        if (book1 != null)
            book1.display();
        else
            System.out.println("Book Not Found");

        // Sort books by title for Binary Search
        Arrays.sort(books, Comparator.comparing(book -> book.title));

        // Binary Search
        System.out.println("\nBinary Search:");
        Book book2 = binarySearch(books, "Python");

        if (book2 != null)
            book2.display();
        else
            System.out.println("Book Not Found");
    }
}