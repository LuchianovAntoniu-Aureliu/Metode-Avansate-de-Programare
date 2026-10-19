public class Book {
    private final String title;
    private final String author;
    private final double price;
    private final int numberOfPages;

    public Book(String title, String author, double price, int numberOfPages) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "The title must not be empty.");
        }

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(
                    "The author must not be empty.");
        }

        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException(
                    "The price must be a valid nonnegative number.");
        }

        if (numberOfPages <= 0) {
            throw new IllegalArgumentException(
                    "The number of pages must be positive.");
        }

        this.title = title.trim();
        this.author = author.trim();
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return title + " (" + price + " Euro, "
                + numberOfPages + " pages)";
    }
}