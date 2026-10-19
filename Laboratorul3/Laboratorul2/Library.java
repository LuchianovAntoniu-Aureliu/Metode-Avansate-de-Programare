import java.util.ArrayList;
import java.util.List;

public class Library {

    // 1. Return all books written by a specified author.
    public List<Book> getBooksByAuthor(List<Book> books, String author) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author.trim())) {
                result.add(book);
            }
        }

        return result;
    }

    // 2. Calculate the average number of pages.
    public double getAveragePages(List<Book> books) {
        if (books.isEmpty()) {
            return 0.0;
        }

        int totalPages = 0;

        for (Book book : books) {
            totalPages += book.getNumberOfPages();
        }

        return (double) totalPages / books.size();
    }

    // 3. Return books whose price is within the given limit.
    public List<Book> getBooksWithinPriceLimit(
            List<Book> books, double maximumPrice) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPrice() <= maximumPrice) {
                result.add(book);
            }
        }

        return result;
    }

    // 4. Return the most expensive book, or null if there are no books.
    public Book getMostExpensiveBook(List<Book> books) {
        if (books.isEmpty()) {
            return null;
        }

        Book mostExpensive = books.get(0);

        for (Book book : books) {
            if (book.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = book;
            }
        }

        return mostExpensive;
    }

    // 5. Return books with at least the specified number of pages.
    public List<Book> getBooksWithMinimumPages(
            List<Book> books, int minimumPages) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getNumberOfPages() >= minimumPages) {
                result.add(book);
            }
        }

        return result;
    }

    // 6. Find two different books with the highest possible total price
    // without exceeding the budget.
    // If prices tie, prefer the pair with more combined pages.
    // Return null if no valid pair exists.
    public BookPair findBestPairWithinBudget(
            List<Book> books, double budget) {

        BookPair bestPair = null;

        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {

                Book firstBook = books.get(i);
                Book secondBook = books.get(j);

                // Do not select the same object twice.
                if (firstBook == secondBook) {
                    continue;
                }

                double totalPrice =
                        firstBook.getPrice() + secondBook.getPrice();

                if (totalPrice <= budget) {
                    BookPair candidate =
                            new BookPair(firstBook, secondBook);

                    int priceComparison = bestPair == null
                            ? 1
                            : Double.compare(
                            candidate.getTotalPrice(),
                            bestPair.getTotalPrice());

                    if (bestPair == null
                            || priceComparison > 0
                            || (priceComparison == 0
                            && candidate.getTotalPages()
                            > bestPair.getTotalPages())) {

                        bestPair = candidate;
                    }
                }
            }
        }

        return bestPair;
    }
}