public class BookPair {
    private final Book firstBook;
    private final Book secondBook;

    public BookPair(Book firstBook, Book secondBook) {
        this.firstBook = firstBook;
        this.secondBook = secondBook;
    }

    public Book getFirstBook() {
        return firstBook;
    }

    public Book getSecondBook() {
        return secondBook;
    }

    public double getTotalPrice() {
        return firstBook.getPrice() + secondBook.getPrice();
    }

    public int getTotalPages() {
        return firstBook.getNumberOfPages()
                + secondBook.getNumberOfPages();
    }

    @Override
    public String toString() {
        return firstBook.getTitle() + " + " + secondBook.getTitle()
                + " = " + getTotalPrice() + " Euro";
    }
}