import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Clean Code", "Robert Martin", 45, 464),
                new Book("1984", "George Orwell", 18, 328),
                new Book("Animal Farm", "George Orwell", 12, 112),
                new Book("Java Basics", "Max Müller", 35, 520),
                new Book("The Hobbit", "J. R. R. Tolkien", 28, 310)
        );

        Library library = new Library();

        // 1. Books by an author
        System.out.println("1. Books by George Orwell:");

        List<Book> authorBooks =
                library.getBooksByAuthor(books, "George Orwell");

        for (Book book : authorBooks) {
            System.out.println(book.getTitle());
        }

        // 2. Average number of pages
        System.out.println("\n2. Average number of pages:");

        List<Book> selectedBooks = Arrays.asList(
                books.get(0), books.get(1), books.get(2));

        System.out.printf("%.2f%n",
                library.getAveragePages(selectedBooks));

        // 3. Books within a price limit
        System.out.println("\n3. Books costing at most 30 Euro:");

        for (Book book : library.getBooksWithinPriceLimit(books, 30)) {
            System.out.println(book);
        }

        // 4. Most expensive book
        System.out.println("\n4. Most expensive book:");

        Book mostExpensive = library.getMostExpensiveBook(books);

        if (mostExpensive != null) {
            System.out.println(mostExpensive);
        } else {
            System.out.println("No books available.");
        }

        // 5. Books with a minimum number of pages
        System.out.println("\n5. Books with at least 300 pages:");

        for (Book book : library.getBooksWithMinimumPages(books, 300)) {
            System.out.println(book.getTitle());
        }

        // 6. Best pair within a budget
        System.out.println("\n6. Best pair within a budget of 55 Euro:");

        BookPair bestPair =
                library.findBestPairWithinBudget(books, 55);

        if (bestPair != null) {
            System.out.println(bestPair);
            System.out.println("Total pages: " + bestPair.getTotalPages());
        } else {
            System.out.println("No valid pair of books.");
        }

        // Additional test: equal prices, different total page counts
        System.out.println("\n7. Test for the tie-breaking rule:");

        List<Book> tieTestBooks = Arrays.asList(
                new Book("Book A", "Author A", 10, 100),
                new Book("Book B", "Author B", 20, 100),
                new Book("Book C", "Author C", 15, 300),
                new Book("Book D", "Author D", 15, 300)
        );

        BookPair tieTestPair =
                library.findBestPairWithinBudget(tieTestBooks, 30);

        if (tieTestPair != null) {
            System.out.println(tieTestPair);
            System.out.println("Total pages: "
                    + tieTestPair.getTotalPages());
        } else {
            System.out.println("No valid pair of books.");
        }
    }
}