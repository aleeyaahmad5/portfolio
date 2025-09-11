package stage2_aleeyaahmad;

public class Book {

    //variables
    private int bookID;
    private String title;
    private String author;
    private String isAvailable;
    static int nextID;

    //constructors
    public Book() {}

    public Book(String title, String author, String availability) {
        this.title = title;
        this.author = author;
        this.bookID = nextID++;
        this.isAvailable = availability;
    }

    public Book(String title, int bookID, String author, String availability) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.isAvailable = availability;
    }

    //functions
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailability(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String isAvailable(){
        return isAvailable;
    }

    public String toString() {
        return "Book ID: " + bookID + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Availability: " + isAvailable + "\n";
    }

}
