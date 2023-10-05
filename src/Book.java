public class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;
    String borrower;
    public Book (String title, String author,String isbn,boolean isAvailable,String borrower) {
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrower = null;
    }
}
